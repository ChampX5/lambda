package com.lambda.primary.Objects.User;

import lombok.Getter;

@Getter
public class AnonymousUser implements BaseUser{
    private final String IPAddress;

    public AnonymousUser(String ipAddress) {
        IPAddress = ipAddress;
    }

    @Override
    public boolean isAuthenticated(){
        return false;
    }
    @Override
    public String toString() {
        return "anonymous";
    }

}
