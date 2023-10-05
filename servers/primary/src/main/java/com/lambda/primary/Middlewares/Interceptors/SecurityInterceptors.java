package com.lambda.primary.Middlewares.Interceptors;


import org.hibernate.proxy.ProxyConfiguration.Interceptor;

import java.lang.reflect.Method;

public class SecurityInterceptors  implements Interceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects) throws Throwable {
        return null;
    }
}
