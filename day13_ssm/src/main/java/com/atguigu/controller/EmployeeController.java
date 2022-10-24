package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
  @Autowired
  @Qualifier("employeeService")
  private EmployeeService employeeService;
  @GetMapping("/emps")
  public  String getAllEmps(Map<String,Object> map){
    List<Employee> employees = employeeService.getEmployees();
    map.put("emps",employees);
    return "emplist";
  }
}
