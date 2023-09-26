package com.lambda.primary.Middlewares.Interceptors;

import com.lambda.primary.Services.AuthTokenServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class AuthorizationInterceptor implements HandlerInterceptor {


    private AuthTokenServices authTokenServices;

    @Autowired
    public AuthorizationInterceptor(AuthTokenServices authTokenServices){
        this.authTokenServices = authTokenServices;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
