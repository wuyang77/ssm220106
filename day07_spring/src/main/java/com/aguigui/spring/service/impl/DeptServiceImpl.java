package com.aguigui.spring.service.impl;

import com.aguigui.spring.dao.DeptDao;
import com.aguigui.spring.pojo.Dept;
import com.aguigui.spring.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    /**
     *作用：自动装配对象中属性
     *装配原理：反射机制
    */
    @Qualifier("deptDao")
    /**
     *作用：配合@Autowired一起使用，将设置beanId名称装配到属性中
     * 注意：不能单独使用，需要与@Autowired一起使用
     */
    private DeptDao deptDao;
    @Override
    public void saveDept(Dept dept) {
        deptDao.insertDept(dept);
    }
}
