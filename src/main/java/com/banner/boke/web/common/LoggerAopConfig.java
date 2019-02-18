package com.banner.boke.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAopConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAopConfig.class);


    @Before("execution(* find*(..))")
    public void invokeBefore(JoinPoint point) {
        String realClassName = getResetClassName(point);
        LOGGER.debug("调用-----"+ realClassName + " 执行 " + getMthodName(point) + " 方法之前");
    }

    @After("execution(* find*(..))")
    public void invokeAfter(JoinPoint point) {
        String realClassName = getResetClassName(point);
        LOGGER.debug("调用-----"+ realClassName + " 执行 " + getMthodName(point) + " 方法之后");
    }



    /**
     * 获取被代理对象的真实类全名
     * @param  //连接点对象
     * @return //真实类全名
     */
    private String getResetClassName(JoinPoint joinPoint){
        return joinPoint.getTarget().getClass().getName();
    }

    /**
     * 获取代理执行的方法名
     * @param
     * @return
     */
    private String getMthodName(JoinPoint joinpoint){
        return joinpoint.getSignature().getName();
    }
}
