package com.example.demo.interceptor;


;
import com.example.demo.service.impl.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Globallinterceptor implements HandlerInterceptor {
@Autowired
    CategoryService categoryService;
@Override

public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    request.setAttribute("cates",categoryService.findAll());
}

}
