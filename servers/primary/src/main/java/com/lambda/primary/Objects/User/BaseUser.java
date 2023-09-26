package com.lambda.primary.Objects.User;

import lombok.Getter;

@Getter
public class BaseUser implements BaseUserInterface{

    private final Long userId;
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;


    public BaseUser(Long userId, String username, String email, String firstName, String lastName) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
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
