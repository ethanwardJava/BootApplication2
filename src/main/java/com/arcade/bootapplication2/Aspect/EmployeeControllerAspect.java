package com.arcade.bootapplication2.Aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Logs controller activity in a concise, Spring Boot–style format.
 */
@Aspect
@Log4j2
@Component
public class EmployeeControllerAspect {

    @Pointcut("execution(public * com.arcade.bootapplication2.Controller.EmployeeController.*(..))")
    public void controllerMethods() { }

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering {} with args {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (result != null) {
            log.info("Completed {} successfully, returned {}", joinPoint.getSignature().getName(), result.getClass().getSimpleName());
        } else {
            log.info("Completed {} with no result", joinPoint.getSignature().getName());
        }
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("Exception in {}: {}", joinPoint.getSignature().getName(), ex.getMessage());
    }

    @Around("controllerMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        log.debug("{} executed in {} ms", joinPoint.getSignature().getName(), time);
        return result;
    }
}
