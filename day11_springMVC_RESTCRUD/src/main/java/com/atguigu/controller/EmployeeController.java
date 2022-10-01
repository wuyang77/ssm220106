package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

  /**
   * 获取所有的员工信息
   */
  @Autowired
  private EmployeeDao employeeDao;
//  @RequestMapping(value = "/emps",method = RequestMethod.GET)
  @GetMapping("/emps")
  public String getAllEmps(Map<String,Object> map){
    Collection<Employee> emps = employeeDao.getAll();
    map.put("emps",emps);
    return "emp_list";
  }
}
