package com.lambda.primary.Services;

import com.lambda.primary.CoreExports.entities.AuthToken;
import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.CoreExports.repos.AuthTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthTokenServices {

    @Autowired
    private AuthTokenRepository authTokenRepository;
    @Autowired
    private UserServices userServices;

    public void createAuthToken(User user, String token){

        AuthToken tokenObject = AuthToken.builder()
                .Id(user.getUserId())
                .token(token)
                .user(user)
                .loggedIn(LocalDateTime.now())
                .build();

        authTokenRepository.save(
                tokenObject
        );


    }



}
