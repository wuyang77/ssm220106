package com.atguigu.service;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
  @Autowired
  private EmployeeMapper employeeMapper;
  @Override
  public List<Employee> getEmployees() {
    return employeeMapper.selectAllEmps();
  }
}
