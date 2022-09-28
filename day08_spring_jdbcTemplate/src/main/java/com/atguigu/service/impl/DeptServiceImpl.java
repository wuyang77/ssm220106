package com.atguigu.service.impl;

import com.atguigu.dao.DeptDao;
import com.atguigu.pojo.Dept;
import com.atguigu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    @Qualifier("deptDaoImpl")
    private DeptDao deptDao;
    @Override
    public List<Dept> getAllDepts() {
        return deptDao.selectAllDepts();
    }
}
