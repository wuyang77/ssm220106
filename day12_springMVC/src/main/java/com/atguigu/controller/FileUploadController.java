package com.atguigu.controller;

import java.io.File;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
  @RequestMapping("/fileUploadController")
  public String fileUploadController(String username, MultipartFile uploadFile, HttpSession session){

    try {
      //获取原始的文件名
      String filename = uploadFile.getOriginalFilename();
      //获取文件上传的真实路径
      String realPath = session.getServletContext().getRealPath("/WEB-INF/upload/");
      //判断路径是否存在，如果不存在则创建文件路径
      File filePath = new File(realPath);
      if (!filePath.exists()) {
        filePath.mkdirs();
      }
      //实现文件上传
      File uFile = new File(realPath+File.separator+filename);
      uploadFile.transferTo(uFile);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "success";
  }
}
