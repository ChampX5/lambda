package com.lambda.primary.Objects.User;

public record RegistrationRecord(
        String username,
        String password,
        String email,
        Long telephone,
        String firstName,
        String lastName
) {
}
