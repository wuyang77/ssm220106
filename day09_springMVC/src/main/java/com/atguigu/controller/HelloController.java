package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //标识当前类是一个请求处理器类
public class HelloController {
    /**
     * 配置UR；【/】，映射到WEB-INF/pages/index.html
     * @return
     */
    @RequestMapping("/")
    public String toIndex(){
        //          /WEB-INF/pages/index.html
        //物理视图名= 视图前缀+逻辑视图名+视图后缀
        return "index";
    }
    @RequestMapping("/HelloControllerMethod")
    public String  HelloWorld(){
        System.out.println("==>HelloController==>HelloWorld");
        return "success";
    }

    @RequestMapping("/ToEmpListPage")
    public String ToEmpListPage(){
        return "empList";
    }
}
