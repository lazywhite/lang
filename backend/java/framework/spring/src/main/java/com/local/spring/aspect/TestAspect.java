package com.local.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/* 基于注解的aop配置类 */

@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(public * com.local.spring.service.impl.*.*Count(..))") //只匹配到会返回int的方法
    public void testPoint(){
    }

//    @AfterReturning(value="testPoint()", returning="result")
    public void returning(int result){
        System.out.println("result is :" + result);
    }

    @Around(value="testPoint()")
    public Object around(ProceedingJoinPoint pjp){
        Object rt = null;
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();
        Object[] args = pjp.getArgs();
        System.out.println("before around: running " + className + ":" + methodName + Arrays.toString(args));
        try {
            rt = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after around");
        return rt;
    }

}
