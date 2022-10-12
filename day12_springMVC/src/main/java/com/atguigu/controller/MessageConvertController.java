package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageConvertController {

    private final static String SUCCESS = "success";

    @RequestMapping("//testRequestBody")
    public String testRequestBody(@RequestBody String reqBody){
        System.out.println("reqBody = " + reqBody);
        return SUCCESS;
    }

    @RequestMapping("/testHttpEntity")
    public String testHttpEntity(HttpEntity<String> httpEntity){
        //获取请求头
        HttpHeaders headers = httpEntity.getHeaders();
        //获取请求体
        String body = httpEntity.getBody();
        System.out.println("body = " + body);
        System.out.println("headers = " + headers);
        return SUCCESS;
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        System.out.println("已经进来并测试了响应体");
        return "hello";
    }

    @RequestMapping(value = "/testJson")
    @ResponseBody
    public Employee testJson(){
        System.out.println("=====>处理Json");
//        int i = 1/0;
        String s = null;
        s.length();
        //将Employee对象装换为Json格式
        Employee employee = new Employee(1001,"wuyang","2388958622@qq.com",1);
        return employee;
    }

}

