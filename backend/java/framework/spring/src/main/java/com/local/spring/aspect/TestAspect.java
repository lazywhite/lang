package com.local.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.local.spring.service..*.*Count(..))") //只匹配到会返回int的方法
    public void testPoint(){
    }


//    @Before(value="testPoint()")
//    public void validLogin(){
//        System.out.println("user logged");
//    }

//    @After(value="testPoint()")
//    public void logArticle(){
//        System.out.println("user logged");
//    }

    @AfterReturning(value="testPoint()", returning="result")
    public void returning(int result){
        System.out.println("result is :" + result);
    }

//    @Around("testPoint()")
//    public void round(ProceedingJoinPoint pjp){
//
//    }
}
