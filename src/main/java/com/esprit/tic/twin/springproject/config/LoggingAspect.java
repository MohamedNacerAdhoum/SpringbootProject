package com.esprit.tic.twin.springproject.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.esprit.tic.twin.springproject.services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Before method " + name + " : ");
    }
    @After("execution(* com.esprit.tic.twin.springproject.services.*.*(..))")
    public void logMethodAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("After method " + name + " : ");
    }
    @AfterThrowing("execution(* com.esprit.tic.twin.springproject.services.*.*(..))")
    public void logMethodAfterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("AfterThrowing method" + name + " : ");
    }
}
