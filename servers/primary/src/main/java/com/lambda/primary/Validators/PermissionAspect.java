package com.lambda.primary.Validators;

import com.lambda.primary.Objects.User.Permissions;
import com.lambda.primary.Services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Aspect
public class PermissionAspect {
    private final HttpServletRequest httpServletRequest;
    @Autowired
    private UserServices userServices;

    public PermissionAspect(HttpServletRequest httpServletRequest){
        this.httpServletRequest = httpServletRequest;
    }

    @Around("@annotation(GrantPermission)")
    public Object validateAccess(ProceedingJoinPoint joinPoint, GrantPermissions permissions) throws Throwable {

        Iterator<Permissions>permissionsIterator =  Arrays.stream(permissions.permission()).iterator();
        Permissions permissionRequest;
        String username = this.httpServletRequest.getHeader("user");
        if(username==null){
            permissionRequest = (Permissions.ANONYMOUS_USER);
        }else {
            Permissions permission = userServices.getUserPermsByUsername(username);
            permissionRequest = (permission);
        }
        while (permissionsIterator.hasNext()){
            if (permissionsIterator.next().equals(permissionRequest)){
                return joinPoint.proceed(joinPoint.getArgs());
            }
        }

        return new JSONObject().put("auth-error","Authentication Error");
    }

}
