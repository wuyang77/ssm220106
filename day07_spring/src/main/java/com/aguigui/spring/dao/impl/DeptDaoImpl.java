package com.aguigui.spring.dao.impl;

import com.aguigui.spring.dao.DeptDao;
import com.aguigui.spring.pojo.Dept;
import org.springframework.stereotype.Repository;


@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {
    @Override
    public void insertDept(Dept dept) {
        System.out.println("添加部门信息成功了！！!");
    }
}
