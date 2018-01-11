package com.skcc.fwk.aop;

import com.skcc.fwk.entity.CommonArea;
import com.skcc.fwk.entity.Commons;
import com.skcc.fwk.entity.Transaction;
import com.skcc.start.repository.jpa.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Aspect
@Component
@Slf4j
public class Advice {

    @Autowired
    ApplicationContext context;

    @Autowired
    TransactionRepository repoTransaction;

    @Around("PointCutList.controllers()")
    public Object aroundLogController(ProceedingJoinPoint pjp) throws Throwable {

        Object obj;

        // CommonArea Setting
        Commons    commons = context.getBean("commons", Commons.class);
        commons.setArea(new CommonArea());
        CommonArea area    = commons.getArea();

        // Set Date "yyMMdd" pattern
        Date             currentTime = new Date();
        SimpleDateFormat formatter   = new SimpleDateFormat("yyMMdd", Locale.KOREA);
        area.setDate(formatter.format(currentTime));

        // Set Time "hhmmss"
        formatter = new SimpleDateFormat("HHmmss", Locale.KOREA);
        area.setTime(formatter.format(currentTime));

        // set ip & url from HttpServlet
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        area.setIp(request.getRemoteAddr());
        area.setUrl(request.getRequestURI());

        try {

            //
            long start = System.currentTimeMillis();

            String methodName = pjp.getSignature().getName();

            log.info("start: " + methodName);
            obj = pjp.proceed();

            long end = System.currentTimeMillis();

            log.info("end: " + (end - start) + "ms");
            area.setElapsed((end-start));

        } catch (Throwable e) {
            throw e;
        }


        // 거래내역 DB 저장
        Transaction transaction = Transaction.builder()
                .day(area.getDate())
                .time(area.getTime())
                .ip(area.getIp())
                .status("200")
                .url(area.getUrl())
                .elapsed(area.getElapsed())
                .build();

        repoTransaction.save(transaction);


        return obj;
    }
}
