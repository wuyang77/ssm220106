package com.atguigu.mybatis.dao.impl;

import com.atguigu.mybatis.dao.DeptDao;
import com.atguigu.mybatis.pojo.Dept;
import org.springframework.stereotype.Repository;
//当注解中只使用一个value的时候，value可以省略
@Repository("deptImpl")
public class DeptDaoImpl implements DeptDao{
    /**
     * 添加部门
     */
    @Override
    public void insertDept(Dept dept) {

    }
}


