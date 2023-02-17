package com.likelion.spring.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
    private final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.likelion.spring.service.*.*(..))")
    public void logBeforeAllMethodCallInServiceLayer(JoinPoint joinPoint) {
        LOG.info("Service layer. Before calling method: {}", joinPoint.toString());
    }

    @After("execution(* com.likelion.spring.service.*.*(..))")
    public void logAfterSuccessfulCallingMethodInServiceLayer(JoinPoint joinPoint) {
        LOG.info("Service layer. After calling method successfully: {}", joinPoint.toString());
    }

    @AfterThrowing("execution(* com.likelion.spring.service.*.*(..))")
    public void logAfterFailCallingMethodInServiceLayer(JoinPoint joinPoint) {
        LOG.info("Service layer. After calling method fail: {}", joinPoint.toString());
    }
}
