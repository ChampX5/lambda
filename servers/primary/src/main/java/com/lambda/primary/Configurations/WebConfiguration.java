package com.lambda.primary.Configurations;

import com.lambda.primary.Middlewares.Interceptors.AuthorizationInterceptor;
import com.lambda.primary.Objects.User.BaseUserConverter;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private AuthTokenServices authTokenServices;
    @Autowired
    private UserServices userServices;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new BaseUserConverter(userServices));
    }

    //public cors mapping
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://loclahost:3000");
    }
}
