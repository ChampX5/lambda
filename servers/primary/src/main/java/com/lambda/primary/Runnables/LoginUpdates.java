package com.lambda.primary.Runnables;

import com.lambda.primary.CoreExports.entities.AuthToken;
import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class LoginUpdates {

    private static final Logger log = LoggerFactory.getLogger(LoginUpdates.class);
    @Autowired private UserServices userServices;
    @Autowired private AuthTokenServices authTokenServices;

    /**
     * Scheduled task for deleting authtokens after a period of 7 days and updates login list
     */
    @Scheduled(fixedDelay = 7L,timeUnit = TimeUnit.DAYS, initialDelay = 7L)
    public void updateLogin(){
        List<AuthToken> authTokens = authTokenServices.fetchAllTokens();

        ListIterator<AuthToken> authTokenIterator = authTokens.listIterator();

        if (authTokens.isEmpty()) return;
        while (authTokenIterator.hasNext()){
            //deletes if the remember user field in the user database is false
            if(authTokenIterator.next().getUser().getRememberUser()){
                authTokenServices.deleteTokenOnId(authTokenIterator.next().getId());
            }
        }
    }

}
