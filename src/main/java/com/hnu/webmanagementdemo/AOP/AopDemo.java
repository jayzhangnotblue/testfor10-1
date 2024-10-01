package com.hnu.webmanagementdemo.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class AopDemo {
    @Pointcut("execution(* com.hnu.webmanagementdemo.Controller.*.*(..))")
    private void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before");
        Object proceed = proceedingJoinPoint.proceed();
        log.info("around after");
        return proceed;
    }
}
