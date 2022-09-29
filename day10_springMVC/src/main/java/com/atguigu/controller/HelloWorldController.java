package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloWorldController")
public class HelloWorldController {
  @RequestMapping("/toRequestDataPage")
  public String toRequestDataPage(){
    return "responseData";
  }
}
