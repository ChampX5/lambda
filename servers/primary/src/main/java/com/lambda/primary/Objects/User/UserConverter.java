package com.lambda.primary.Objects.User;


import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, BaseUser> {
    @Override
    public BaseUser convert(String value) {
        if(value.equalsIgnoreCase("-1")){
            return new AnonymousUser();
        }
        return new BaseUser(
                1,
                "admin",
                "admin@email.com"
        );
    }


}
