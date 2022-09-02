package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component //将当前类标识唯一的组件
@Aspect    //将当前类标识为【切面类】;非核心业务提取类
public class MyLogging {
    /**
     * 方法之前
     */
    @Before(value = "execution(public int com.atguigu.aop.CalcImpl.add(int,int))")
    public static void beforeMethod(JoinPoint joinPoint){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("==>Calc中"+methodName+"方法()，参数:"+ Arrays.toString(args));
    }
    /**
     * 方法之后
     */
    public static void afterMethod(String methodName,Object rs){
        System.out.println("==>Calc中"+methodName+"方法()，结果+"+rs);
    }
}
