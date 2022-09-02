package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Employee;

import java.util.List;

public interface EmployeeMapper{
    /**
     * 通过员工id获取员工信息以及所属员工部门信息
     * @param empid
     * @return
     */
    public List<Employee> selectEmpAndDeptByEmpId(int empId);
    public Employee selectEmpAndDeptByEmpIdAssociation(int empId);
}
