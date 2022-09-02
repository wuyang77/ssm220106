package com.atguigu.mybatis.service.impl;

import com.atguigu.mybatis.dao.DeptDao;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.service.DeptService;
import org.springframework.stereotype.Service;

@Service("deptServiceImpl")
public class DeptServiceImpl implements DeptService {
    private DeptDao deptDao; //= new DeptImpl();
    @Override
    public void savaDept(Dept dept) {
        System.out.println("==>添加部门信息成功啦！！！");
        deptDao.insertDept(dept);
    }

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }
}
