package com.skcc.fwk.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutList {

    @Pointcut("execution(* com.skcc..controller..*.*(..))")
    public void controllers() {
    }

}
