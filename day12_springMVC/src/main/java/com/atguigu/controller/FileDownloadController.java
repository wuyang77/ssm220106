package com.atguigu.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FileDownloadController {

  @RequestMapping("/fileDownloadController")
  public ResponseEntity<byte[]> fileDownloadController(HttpServletRequest request,String filename){

    ResponseEntity<byte[]> responseEntity = null;
    try {
      System.out.println("===》已经进入文件下载的控制器");
      //获取目标文件的真实路径【request/session->ServletContext】
      String realPath = request.getServletContext().getRealPath("/WEB-INF/download/"+filename);
      //创建输入流
      InputStream is = new FileInputStream(realPath);

      //文件下载byte[]
      byte[] bytes = new byte[is.available()];
      is.read(bytes);
      //设置响应头
      HttpHeaders headers = new HttpHeaders();
      //设置要下载的文件的名字【及文件格式为附件格式，通知服务器下载当前资源，而不是打开】
      headers.add("Content-Disposition","attachment;filename="+filename);
      //处理中文文件名问题
      headers.setContentDispositionFormData("attachment",new String(filename.getBytes("utf-8"),"ISO-8859-1"));

      responseEntity = new ResponseEntity<>(bytes,headers, HttpStatus.OK);
      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return responseEntity;
  }
}
