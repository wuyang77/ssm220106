package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Department;
import com.atguigu.pojo.Employee;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class EmployeeController {

  /**
   * 获取所有的员工信息
   */
  @Autowired
  private EmployeeDao employeeDao;
  @Autowired
  private DepartmentDao departmentDao;
//  @RequestMapping(value = "/emps",method = RequestMethod.GET)
  @GetMapping("/emps")
  public String getAllEmps(Map<String,Object> map){
    Collection<Employee> emps = employeeDao.getAll();
    map.put("emps",emps);
    return "emp_list";
  }
  @GetMapping("/toSaveEmp")
  public String toSaveEmp (Map < String, Object > map){
    //查询所有的部门信息
    Collection<Department> departments = departmentDao.getDepartments();
    map.put("depts",departments);
    return "emp_save";
  }

  @PostMapping("/emps")
  public String saveEmp(Employee employee){
    employeeDao.save(employee);
    return "redirect:/emps";
  }
  @DeleteMapping("/emps/{empId}")
  public String deleteEmp(@PathVariable("empId")Integer empId){
    employeeDao.delete(empId);
    return "redirect:/emps";
  }
  @GetMapping("/toUpdateEmp/{empId}")
  public String toUpdateEmp(@PathVariable("empId")Integer empId,Map<String,Object> map){
    //通过empId,获取员工信息
    Employee employee = employeeDao.get(empId);
    map.put("emp",employee);
    //获取所有部门信息
    Collection<Department> departments = departmentDao.getDepartments();
    map.put("depts",departments);
    return "emp_update";
  }
  @PutMapping("/emps")
  public String updateEmp(Employee employee){
    //修改用户
    employeeDao.save(employee);
    return "redirect:/emps";
  }
}
