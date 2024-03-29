package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLOutput;

@Controller
public class EmployeeController {
    public final static String SUCCESS = "success";
    /**
     * 添加员工信息
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String saveEmp(){
        System.out.println("==>添加员工信息");
        return SUCCESS;
    }
    /**
     * 查询员工信息
     */
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.GET)
    public String getEmpBId(@PathVariable("empId")Integer empId){
        System.out.println("empId = " + empId);
        return SUCCESS;
    }

    /**
     * 修改员工信息
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String updateEmp(){
        System.out.println("==>修改员工信息！！！");
        return SUCCESS;
    }
    /**
     * 删除员工信息
     * @return
     */
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.DELETE)
    public String updateEmp(@PathVariable("empId") Integer method){
        System.out.println("==>删除员工信息！！！");
        return SUCCESS;
    }
}
