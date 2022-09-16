package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/EmpController")
public class EmployeeController {
     private final static String SUCCESS = "success";
    @RequestMapping(value = {"/saveEmp","/insertEmp"},
                    method = RequestMethod.GET,
                    params = "lastName=lishi",
                    headers = "User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
    /**
     * 测试Ant风格的URL
     */
    public String saveEmp(){
        System.out.println("添加员工信息！！！！");
        return SUCCESS;
    }
    @RequestMapping("/testAnt/**")
    public String testAnt(){
        System.out.println("==>testAnt");
        return SUCCESS;
    }

    /**
     * testPathVaribable
     * @return
     */
    @RequestMapping("/testPathVariable/{empId}")//书写在参数的前面,获取路径中的变量
    public String testVariable(
            @PathVariable(value = "empId",required = false) Integer empId){
        System.out.println("empId = " + empId);
        return SUCCESS;
    }
}
