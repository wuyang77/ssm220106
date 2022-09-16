package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(value = 1)
public class MyValidate {
    /**
     * 添加数据验证功能
     */
    @Before(value = "MyLogging.myPointCut()")
    public void methodBefore(JoinPoint joinPoint){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("=======>>>>>>>>数据验证的切面");
    }
}
