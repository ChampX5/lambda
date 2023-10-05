package com.lambda.primary.Validators;


import com.lambda.primary.Objects.User.BaseUser;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@Aspect
@Component
public class AuthenticationAspect {

    private final HttpServletRequest request;
    @Autowired
    private ConversionService conversionService;
    public AuthenticationAspect(HttpServletRequest request){
        this.request=request;
    }
    @Around("@annotation(IsAuthenticated)")
    @ResponseStatus(code = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
    public Object authenticateUser(ProceedingJoinPoint joinPoint) throws Throwable {

        String user = request.getHeader(
                "user"
        );

        if( user !=null &&
                Objects.requireNonNull(conversionService.convert(
                        user,
                        BaseUser.class
                )).isAuthenticated()) {
            return joinPoint.proceed();
        }
        return new JSONObject().put("auth-error","User is not authenticated").toString();
    }

}
