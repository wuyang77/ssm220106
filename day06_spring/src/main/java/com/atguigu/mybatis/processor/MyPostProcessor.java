package com.atguigu.mybatis.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

public class MyPostProcessor implements BeanPostProcessor {
    /**
     * 在Bean的初始化之前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==>Bean的初始化之前执行!!!");
        return bean;
    }

    /**
     * 在Bean的初始化之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("==>Bean的初始化之后执行!!!");
        return bean;
    }
}
