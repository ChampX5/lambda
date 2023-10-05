package com.lambda.primary.Objects.User;


import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class BaseUserConverter implements Converter<String, BaseUser> {
    private UserServices userServices;
    @Autowired
    private AuthTokenServices authTokenServices;

    @Autowired
    public BaseUserConverter(UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public BaseUser convert(String value) {
        if(value.equalsIgnoreCase("-1")){
            return new AnonymousUser();
        }

        Long id = userServices.fetchIdOnUsername(value);
        User user =  userServices.fetchUserOnUsername(value);

        if(authTokenServices.existsById(id)){
            return new BaseUser(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getFirst_name(),
                    user.getLast_name(),
                    true
            );
        }

        return new BaseUser(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirst_name(),
                user.getLast_name(),
                false
        );
    }


}
