package com.atguigu.beforeaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {
    /**
     * 目标对象【目标客户】
     */
    private Object target;

    public MyProxy(Object target){
        this.target = target;
    }

    /**
     * 获取目标对象的，代理对象
     * @return
     */
    public Object getProxyObject(){
        Object proxyObj = null;
        /**
         * ClassLoader loader 目标对象类加载器
         * Class<?>[] interfaces 目标对象实现所有接口
         * InvocationHandler h
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //创建代理对象
        proxyObj = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            //执行invoke（）实现动态织入的效果
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取方法名【目标对象】
                String methodName = method.getName();
                //执行目标之前，添加日志
                MyLogging.beforeMethod(methodName, args);
                //触发目标对象的目标方法
                Object rs = method.invoke(target, args);
                //执行目标方法之后，添加日志
                MyLogging.afterMethod(methodName, rs);
                return rs;
            }
        });
        return proxyObj;
    }
}
