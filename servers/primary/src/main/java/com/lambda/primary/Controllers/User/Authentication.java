package com.lambda.primary.Controllers.User;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Objects.User.Operations;
import com.lambda.primary.Objects.User.UserRecord;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("user/auth/")
public class Authentication {

    @Autowired
    private Operations operations;
    @Autowired
    UserServices userServices;

    @Autowired
    AuthTokenServices authTokenServices;

    @PostMapping
    public String authenticate(
            @RequestBody UserRecord record
    )  {
        JSONObject JSON = new JSONObject();

        //Authenticating user
        User user = operations.authenticate(record.password(), record.username());

        if(user==null){
            //returning denied access
            JSON.put("auth_status","denied");
        }else{
            try{
                String token = operations.generateAuthToken(user);
                JSONObject auth = new JSONObject();
                auth.put("username",user.getUsername());
                auth.put("token", token);
                JSON.put("auth_status","success")
                .put(
                        "auth_user",
                        auth
                );
            }catch (NoSuchAlgorithmException e){
                e.fillInStackTrace();
                return new JSONObject().put("auth_status","exception").toString();
            }
        }

        return JSON.toString();
    }

}
