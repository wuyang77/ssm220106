package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component //将当前类标识唯一的组件
@Aspect    //将当前类标识为【切面类】;非核心业务提取类
@Order(2)
public class MyLogging {
    //重用切入点表达式
    @Pointcut("execution(* com.atguigu.aop.CalcImpl.*(..))")
    public void myPointCut(){}
    /**
     * 前置通知
     */
//    @Before(value = "execution(public int com.atguigu.aop.CalcImpl.add(int,int))")
//    @Before(value = "myPointCut()")
    public static void beforeMethod(JoinPoint joinPoint){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【前置通知】==>Calc中"+methodName+"方法()，参数:"+ Arrays.toString(args));
    }
    /**
     * 后置通知
     */
//    @After(value = "myPointCut()")
    public void afterMethod(JoinPoint joinPoint){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【后置通知】==>Calc中"+methodName+"方法之后执行！"+Arrays.toString(args));
    }
    /**
     * 返回通知
     */
//    @AfterReturning(value = "myPointCut()",returning = "rs")
    public void afterReturning(JoinPoint joinPoint,Object rs){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【返回通知】==>Calc中"+methodName+"方法之后执行！"+rs);
    }
    /**
     * 异常通知
     */
//    @AfterThrowing(value = "myPointCut()",throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【异常通知】==>Calc中"+methodName+"方法有异常时执行!异常："+ex);
    }
    /**
     * 环绕通知
     */
    @Around(value = "myPointCut()")
    public Object aroundMethod(ProceedingJoinPoint pjp){
        //获取方法名称
        String methodName = pjp.getSignature().getName();

        //获取参数
        Object[] args = pjp.getArgs();
        Object rs = null;
        try {
            //前置通知
            System.out.println("【前置通知】==>Calc中"+methodName+"方法()，参数:"+ Arrays.toString(args));
            //触发目标对象的目标方法【加减乘除法】
            rs = pjp.proceed();
            //返回通知【有异常时不执行】
            System.out.println("【返回通知】==>Calc中"+methodName+"方法之后执行！"+rs);
        } catch (Throwable e) {
            //异常通知【有异常时执行】
            e.printStackTrace();
            System.out.println("【异常通知】==>Calc中"+methodName+"方法有异常时执行!异常：");
        }finally {
            //后置通知
            System.out.println("【后置通知】==>Calc中"+methodName+"方法之后执行！"+Arrays.toString(args));
        }
        return rs;
    }
}
