package com.atguigu.dao;

import com.atguigu.pojo.Department;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<>();

        employees.put(1001,new Employee(1001,"E-AA","aa@qq.com",1,new Department(101,"D-AA")));
        employees.put(1001,new Employee(1002,"E-BB","bb@qq.com",1,new Department(102,"D-BB")));
        employees.put(1001,new Employee(1003,"E-CC","cc@qq.com",0,new Department(103,"D-CC")));
        employees.put(1001,new Employee(1004,"E-DD","dd@qq.com",0,new Department(104,"D-DD")));
        employees.put(1001,new Employee(1005,"E-EE","ff@qq.com",1,new Department(105,"D-EE")));
    }

}
