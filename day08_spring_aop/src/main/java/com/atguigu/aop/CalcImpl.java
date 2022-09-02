package com.atguigu.aop;

import org.springframework.stereotype.Component;

@Component("calc")
public class CalcImpl implements Calc{
    @Override
    public int add(int a, int b) {
        int result = a+b;
        System.out.println("正在计算中。。。。");
        return result;
    }

    @Override
    public int sub(int a, int b) {
//        MyLogging.beforeMethod("add",new Object[]{a,b});

        int result = a-b;
        System.out.println("正在计算中。。。。");
//        MyLogging.afterMethod("add",result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a*b;
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a/b;
        return result;
    }
}
