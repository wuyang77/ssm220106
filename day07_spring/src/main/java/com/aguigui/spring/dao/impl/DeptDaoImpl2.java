package com.aguigui.spring.dao.impl;

import com.aguigui.spring.dao.DeptDao;
import com.aguigui.spring.pojo.Dept;
import org.springframework.stereotype.Repository;

@Repository("deptDao2")
public class DeptDaoImpl2 implements DeptDao {
    @Override
    public void insertDept(Dept dept) {
        System.out.println("==>DeptDaoImpl2222222222!!!");
    }
}
