package com.lyw.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    HttpSession session = request.getSession();
    Object user = session.getAttribute("user");
    if (user == null)
    {
      request.setAttribute("meg", "对不起您没有权限访问！请登录后访问");
      request.getRequestDispatcher("/").forward(request, response);
      return false;
    }
    return true;
  }

}
