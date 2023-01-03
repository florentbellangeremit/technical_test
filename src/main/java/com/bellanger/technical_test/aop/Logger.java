package com.bellanger.technical_test.aop;


import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class Logger {

    long timer;

    @Pointcut("execution( public * com.bellanger.technical_test.controller.*Controller.*(..))")
    public void interceptor() {

    }

    @Before("interceptor()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Before");
        for (Object o : joinPoint.getArgs()) {
            log.info(o.toString());
        }
        log.info(joinPoint.getSignature().toString());
        timer = System.currentTimeMillis();

    }

    @AfterReturning(value = "interceptor()", returning = "responseEntity")
    public void logAfter(JoinPoint joinPoint, ResponseEntity responseEntity) {
        log.info("After");
        log.info(joinPoint.getSignature().toString());
        log.info(responseEntity.toString());
        log.info("Elapsed time : {}ms", System.currentTimeMillis() - timer);
    }

    @AfterThrowing("interceptor()")
    public void logThrowing() {
        log.error("error");
    }

}
