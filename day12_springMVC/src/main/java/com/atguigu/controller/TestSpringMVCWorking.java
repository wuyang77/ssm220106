package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class TestSpringMVCWorking {
  /**
   * 测试SpringMVC工作原理
   */
  @GetMapping("/testSpringMVCWorking")
  public String testSpringMVCWorking(){
    System.out.println("==>TestSpringMVCWorking!");
    return "success";
  }
}
