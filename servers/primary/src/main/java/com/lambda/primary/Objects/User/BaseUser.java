package com.lambda.primary.Objects.User;

import lombok.Getter;

@Getter
public class BaseUser implements BaseUserInterface{

    private final int userId;
    private final String username;
    private final String email;


    public BaseUser(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    @Override
    public boolean isAuthenticated() {
        return userId > 0;
    }

    @Override
    public String toString() {
        return "BaseUser";
    }


}
