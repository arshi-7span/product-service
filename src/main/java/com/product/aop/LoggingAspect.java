package com.product.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.product.controller..*(..))")
    public void controllerMethods() {}

    @Pointcut("execution(* com.product.handler..*(..))")
    public void handlerMethods() {}

    @Pointcut("execution(* com.product.service..*(..))")
    public void serviceMethods() {}

    @Before("controllerMethods()")
    public void logControllerMethodEntry(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- START", className, methodName);
        log.info("Request received params: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("controllerMethods()")
    public void logControllerMethodExit(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- END", className, methodName);
    }

    @Before("handlerMethods()")
    public void logHandlerMethodEntry(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- START", className, methodName);
        log.info("Request received params: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("handlerMethods()")
    public void logHandlerMethodExit(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- END", className, methodName);
    }

    @Before("serviceMethods()")
    public void logServiceMethodEntry(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- START", className, methodName);
        log.info("Request received params: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("serviceMethods()")
    public void logServiceMethodExit(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("{} @{} method -- END", className, methodName);
    }
}
