package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    public final static String SUCCESS = "success";
    /**
     * 添加员工
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String saveEmp(){
        System.out.println("==>添加员工信息");
        return SUCCESS;
    }
    /**
     * 查询员工
     */
    //http://localhost:8080/day10_springMVC_war_exploded/emp
    //如果你跳这个需要员id   /emp/{empId}
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.GET)
    public String getEmpBId(@PathVariable("empId")Integer empId){
        System.out.println("empId = " + empId);
        return SUCCESS;
    }
}
