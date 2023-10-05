package com.lambda.primary.Services;

import com.lambda.primary.CoreExports.entities.AuthToken;
import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.CoreExports.repos.AuthTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public AuthToken fetchUserOnAuthToken(String authToken){
        return authTokenRepository.queryAuthTokenFromToken(authToken);
    }

    public String fetchUsernameOnAuthToken(String authToken){
        AuthToken token = authTokenRepository.queryAuthTokenFromToken(authToken);
        if(token!=null){
            return userServices.fetchUserOnUserId(token.getId()).getUsername();
        }
        return null;
    }

    public boolean existsById(Long id){
        return authTokenRepository.existsById(id);
    }

    public List<AuthToken> fetchAllTokens(){
        return this.authTokenRepository.queryAllTokens();
    }


    @Transactional
    public void deleteTokenOnId(Long Id){
        authTokenRepository.queryDeleteTokenFromId(Id);
    }
}
