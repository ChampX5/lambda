package com.lambda.primary.Middlewares.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class Authentication implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getProtocol().equals("HTTP/1.1")){
            //Authenticate
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
