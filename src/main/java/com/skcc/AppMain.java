package com.skcc;

import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication(scanBasePackages = {"com.skcc"})
@Slf4j
public class AppMain {
//    private final Logger log = LoggerFactory.getLog(AppMain.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext run                 = SpringApplication.run(AppMain.class, args);
        String[]                       beanDefinitionNames = run.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames);
        for (String name : beanDefinitionNames) {
            log.debug("name: {}" ,name);
        }
    }
}
