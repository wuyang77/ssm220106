package com.atguigu.mybatis.mapper;


import com.atguigu.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpolyeeMapper {
    /**
     * 按条件查询员工信息【多个条件不确定】if-where
     * @param employee
     * @return
     */
    public List<Employee> selectEmpByOpr(Employee employee);

    /**
     * 按条件查询员工信息【条件不确定】trim
     * @param employee
     * @return
     */
    public List<Employee> selectEmpByOprTrim(Employee employee);

    /**
     * 按条件修改员工的信息【条件不确定】
     * @param employee
     */
    public void updateEmpByOpr(Employee employee);
    /**
     * 按条件修改员工的信息【单个条件不确定】if-where
     * @param employee
     */
    public List<Employee> updateEmpByOneOpr(Employee employee);

    /**
     * 通过多个Id获取员工的信息【ids:员工的集合】
     * @param ids
     * @return
     */
    public List<Employee> selectEmpByIds(@Param("ids") List<Integer> ids);

    /**
     * 测试批量添加员工
     * @param employee
     */
    public void batchInsertEmp(@Param("employees") List<Employee> employee);
}
