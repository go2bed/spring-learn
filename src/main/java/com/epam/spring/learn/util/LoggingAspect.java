package com.epam.spring.learn.util;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* *.logEvent(..))")
    public void allLogEventMethods(){}

    @Before("allLogEventMethods()")
    public void logBefore(){
        System.out.println(" it is a life and logging "
       );
    }
}
