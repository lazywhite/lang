package com.local.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by white on 17/7/12.
 */
public class LoggingAspect {

    public void before(){
        System.out.println("logging before");
    }

    public void after(){
        System.out.println("logging after");
    }

    public void around(ProceedingJoinPoint pjp){
        StopWatch watch = new StopWatch();
        watch.start();
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        watch.stop();
        Long timeCost = watch.getTotalTimeMillis();
        System.out.println(watch.prettyPrint());
        System.out.println("total time millis: " + timeCost);

    }
}
