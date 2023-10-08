package com.lambda.primary.Models.User;


public record RegistrationModel(
        String username,
        String password,
        String email,
        Long telephone,
        String firstName,
        String lastName,
        boolean rememberUser
) { }
