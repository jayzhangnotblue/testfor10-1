package com.hnu.webmanagementdemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class Xilterdemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始方法执行：Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("demo拦截到请求,放行前逻辑");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("放行后逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行：Destroy");
    }
}
