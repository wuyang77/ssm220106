package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;
import com.atguigu.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {
  @Autowired
  @Qualifier("employeeService")
  private EmployeeService employeeService;
  @GetMapping("/emps/{pageNo}")
  public  String getAllEmps(@PathVariable("pageNo")Integer pageNo,
                            Map<String,Object> map,
                            HttpServletRequest request){
    int pNo = 1;
    if (pageNo != null){
      pNo = pageNo;
    }
    //开启分页
    PageHelper.startPage(pNo,5);
    map.put("pNo",pNo);
    List<Employee> employees = employeeService.getEmployees();
    //分装分页
    PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
    //使用工具类，获取分页信息
    String pageRs = PageUtils.getPageInfo(pageInfo,request);
    //将数据共享到域中
    map.put("pageRs",pageRs);
    map.put("emps",employees);
    return "emplist";
  }
}
