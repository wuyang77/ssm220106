package com.aguigui.spring.controller;

import com.aguigui.spring.pojo.Dept;
import com.aguigui.spring.service.DeptService;
import org.springframework.stereotype.Controller;

@Controller("deptController")
public class DeptController {
    private DeptService deptService;
    public void saveDept(){
        deptService.saveDept(new Dept());
    }
}
