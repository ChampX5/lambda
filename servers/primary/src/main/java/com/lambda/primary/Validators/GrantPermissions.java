package com.lambda.primary.Validators;

import com.lambda.primary.Objects.User.Permissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.crypto.dsig.Reference;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@RequestMapping(method = {
        RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.PATCH,RequestMethod.DELETE,
        RequestMethod.GET
})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GrantPermissions {
    Permissions[] permission() default {};
}
