package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestRequestDataParam {
  public final static String SUCCESS = "success";

  /**
   * 获取请求参数1
   * @return
   */
  @RequestMapping("/requestParam1")
  public String requestParam1(@RequestParam(value = "ssName",required = false,defaultValue = "zhangsan") String stuName,
                              Integer stuAge){
    System.out.println("stuName = " + stuName);
    System.out.println("stuAge = " + stuAge);
    return SUCCESS;
  }

  /**
   * 获取pojo参数
   * @param employee
   * @return
   */
  @RequestMapping("/saveEmp")
  public String saveEmp(Employee employee){
    System.out.println("employee = " + employee);
    return SUCCESS;
  }
}
