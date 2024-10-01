package com.hnu.webmanagementdemo.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class Filterdemo2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("demo2放行之前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("demo2:after");
    }
}
