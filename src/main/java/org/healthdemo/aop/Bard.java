package org.healthdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Bard {

/*
    @Pointcut("execution(* org.healthdemo.service.impl.KnightServiceImp.getAchievement(..))")
    public void serviceBefore() {}

    @Before(value = "serviceBefore()")
    public void getSong(JoinPoint joinPoint) {
        System.err.println("LALAla song!");
    }
*/

    @Around("execution(* org.healthdemo.service.impl.KnightServiceImp.getAchievement(..)) && args(value, ..)")
    public Object action(ProceedingJoinPoint joinPoint, String value) throws Throwable {
        long timeBefore = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeAfter = System.currentTimeMillis();
        System.err.println("LLLLAA");
        System.err.println("Knight defeat an enemy - " + value + " with " + ((timeAfter - timeBefore) / 1000) + "s");
        return obj;
    }
}
