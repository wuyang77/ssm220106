package com.atguigu.mybatis.factory;

import com.atguigu.mybatis.pojo.Dept;
import org.springframework.beans.factory.FactoryBean;

public class MyfactoryBean implements FactoryBean<Dept>{
    /**
     * 参数对象创建的方法
     * @return
     * @throws Exception
     */
    @Override
    public Dept getObject() throws Exception {
        Dept dept = new Dept(101,"研发部门");
        //...此处省略一万行代码
        return dept;
    }

    /**
     * 设置参数对象Class
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Dept.class;
    }

    /**
     * 设置当前Bean是否是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

}
