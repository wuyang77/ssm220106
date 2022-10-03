package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
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
  /**
   * 获取请求头
   */
  @RequestMapping("/testGetHeader")
  public String testGetHeader(@RequestHeader("Accept-Language")String al,
                              @RequestHeader("Referer")String ref){
    System.out.println("al = " + al);
    System.out.println("ref = " + ref);
    return SUCCESS;
  }
  /**
   * 设置cookie数据
   */
  @RequestMapping("/setCookie")
  public String setCookie(HttpSession session){
//    Cookie cookie = new Cookie();
    System.out.println("session.getId() = " + session.getId());
    return SUCCESS;
  }

  /**
   * 获取cookie数据
   * @param
   * @return
   */
  @RequestMapping("/getCookie")
  public String getCookie(@CookieValue("JSESSIONID")String cookieValue){
    System.out.println("cookieValue = " + cookieValue);
    return SUCCESS;
  }
  @RequestMapping("/useHttpRequest")
  public String useHttpRequest(HttpServletRequest request){
    ServletContext servletContext = request.getServletContext();
    String realPath = servletContext.getRealPath("/WEB-INF/pages/index.html");
    System.out.println("realPath = " + realPath);
    return SUCCESS;
  }
}
