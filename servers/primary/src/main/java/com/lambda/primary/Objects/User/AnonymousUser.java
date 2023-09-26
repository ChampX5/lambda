package com.lambda.primary.Objects.User;

import lombok.Getter;

@Getter
public class AnonymousUser extends BaseUser {
    private String IPAddress;
    public final int ANONYMOUS_USER_ID= -1;


    public AnonymousUser() {
        super(
                -1L,
                null,
                null,
                "-1", "-1");
    }

    @Override
    public String toString() {
        return "AnonymousUser";
    }

}
