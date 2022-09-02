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
    /**
     * 通过员工id获取员工信息及员工所属的部门信息【分步查询】
     *      1，先通过员工id获取员工信息【id,last_name,email,salary,dept_id】
     *      2.再通过部门id获取部门信息【dept_id,dpt_name】
     *      提高程序运行的效率
     */
    public Employee selectEmpAndDeptByEmpIdAssociationStep(int empId);
    /**
     * 通过部门id获取员工信息
     */
    public List<Employee> selectEmpByDeptId(int deptId);
    /**
     * 按条件查询员工信息【条件不确定（Employee）】
     */
    public List<Employee> selectEmployeeByOpr(Employee employee);
}
