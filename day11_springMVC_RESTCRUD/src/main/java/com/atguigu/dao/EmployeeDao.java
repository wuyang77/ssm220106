package com.atguigu.dao;

import com.atguigu.pojo.Department;
import com.atguigu.pojo.Employee;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
  private static Map<Integer, Employee> employees =null;
  @Autowired
  private DepartmentDao departmentDao;
  static {
    employees = new HashMap<>();
    employees.put(1001,new Employee(1001,"E-AA","aa@qq.com",1,new Department(101,"D-AA")));
    employees.put(1002,new Employee(1002,"E-BB","bb@qq.com",1,new Department(102,"D-BB")));
    employees.put(1003,new Employee(1003,"E-CC","cc@qq.com",0,new Department(103,"D-CC")));
    employees.put(1004,new Employee(1004,"E-DD","dd@qq.com",0,new Department(104,"D-DD")));
    employees.put(1005,new Employee(1005,"E-EE","ee@qq.com",1,new Department(105,"D-EE")));
  }
  private static Integer initId = 1006;

  /**
   * 添加或修改员工信息
   * @param employee
   */
  public void save(Employee employee){
    if (employee.getId() == null){
      employee.setId(initId++);
    }
    employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
    employees.put(employee.getId(),employee);
  }

  /**
   * 获取所有员工信息
   * @return
   */
  public Collection<Employee> getAll(){
    return employees.values();
  }

  /**
   * 通过id获取员工信息
   * @param id
   * @return
   */
  public Employee get(Integer id){
    return employees.get(id);
  }

  /**
   * 删除员工信息
   * @param id
   */
  public void delete(Integer id){
    employees.remove(id);
  }
}
