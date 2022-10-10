package com.atguigu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class MyInterCeptor implements HandlerInterceptor{

  /**
   * 执行1【Controller执行之前】
   * @param request current HTTP request
   * @param response current HTTP response
   * @param handler chosen handler to execute, for type and/or instance evaluation
   * @return
   * @throws Exception
   */
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("==>MyInterCeptor->preHandle()!");
    return true;
  }

  /**
   * 执行1【Controller执行之后】
   * @param request current HTTP request
   * @param response current HTTP response
   * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
   * execution, for type and/or instance examination
   * @param modelAndView the {@code ModelAndView} that the handler returned
   * (can also be {@code null})
   * @throws Exception
   */
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    System.out.println("==>MyInterCeptor->postHandle()!");
  }

  /**
   *最好执行【渲染视图之后】
   * @param request current HTTP request
   * @param response current HTTP response
   * @param handler the handler (or {@link HandlerMethod}) that started asynchronous
   * execution, for type and/or instance examination
   * @param ex any exception thrown on handler execution, if any; this does not
   * include exceptions that have been handled through an exception resolver
   * @throws Exception
   */
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    System.out.println("==>MyInterCeptor->afterCompletion");
  }
}
