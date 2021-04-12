package com.lyw.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {

  @Autowired
  StringRedisTemplate redisTemplate;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //获取当前请求地址
    String uri = request.getRequestURI();
    //将当前请求资源地址作为key自加一
    redisTemplate.opsForValue().increment(uri);
    return true;
  }
}
