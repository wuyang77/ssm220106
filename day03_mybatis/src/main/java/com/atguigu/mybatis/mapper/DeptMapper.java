package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;

public interface DeptMapper {
    /**
     * 通过部门id获取部门信息
     */
    public Dept selectDeptByDeptId(int deptId);
    /**
     * 通过部门id获取部门信息，及部门中所属的员工信息
     */
    public Dept selectDeptAndEmpByDeptId(int deptId);
    public Dept selectDeptAndEmpByDeptIdStep(int deptId);
}
