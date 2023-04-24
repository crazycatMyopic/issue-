package com.ard333.springbootwebfluxjjwt.rest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {

    @Pointcut("within(com.ard333.springbootwebfluxjjwt..*)")
    public void logEveryFunction() {
    }

    @Before(value = "logEveryFunction()")
    public void log(JoinPoint joinPoint) {
        log.info("Entering function {} in location {}", joinPoint.getSignature(), joinPoint.getSourceLocation());
    }

    @After(value = "logEveryFunction()")
    public void logEnd(JoinPoint joinPoint) {
        log.info("Exiting function {}", joinPoint.getSignature());
    }
}
