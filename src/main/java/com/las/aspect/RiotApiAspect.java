package com.las.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by atlantis on 24/01/17.
 */
@Aspect
@Component
public class RiotApiAspect {

    public static final Logger LOGGER = Logger.getLogger(RiotApiAspect.class.getName());

    @Before("execution(* com.las..*(..))")
    public void before(JoinPoint joinPoint) {
        LOGGER.log(Level.INFO, "Calling method " + joinPoint.getSignature().getName()
                + " with these params " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.las..*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.log(Level.INFO, "Method ran without any error");
    }

    @AfterReturning(pointcut = "execution(* com.las..*(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        LOGGER.log(Level.INFO, "Result was " + result.toString());
    }
}
