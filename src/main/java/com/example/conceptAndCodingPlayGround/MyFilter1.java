package com.example.conceptAndCodingPlayGround;

import jakarta.servlet.*;

import java.io.IOException;


public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("Filter 1 init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter 1 doFilter start");
        chain.doFilter(request, response);
        System.out.println("Filter 1 doFilter end");
    }

    @Override
    public void destroy() {
        System.out.println("Filter 1 destroy");
        Filter.super.destroy();
    }
}
