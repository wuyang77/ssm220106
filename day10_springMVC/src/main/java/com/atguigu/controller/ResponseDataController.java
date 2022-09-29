package com.atguigu.controller;

import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ResponseDataController")
public class ResponseDataController {
  @RequestMapping("/testModelAndView")
  public ModelAndView testModelAndView(){
    ModelAndView mv = new ModelAndView();
    //设置数据【将数据共享到域中】
    mv.addObject("stuName","lilong");
    //设置视图【转发或者重定向】
    mv.setViewName("response_success");
    return mv;
  }

  @RequestMapping("/testModelOrModelMapOrMap")
  public String testModelOrModeMapOrMap(Model model/*Map<String,Object> map*/){
    //设置数据
//    map.put("stuName","lisi");
    model.addAttribute("stuName","Yang Wu");
    return "response_success";
  }
  @RequestMapping("/testSession")
  public String testSession(HttpSession session){
    //设置数据Session域
    session.setAttribute("stuName","Shiqing Wu");
    return "response_success";
  }
}
