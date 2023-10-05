package com.lambda.primary.Controllers.User;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Objects.User.BaseUser;
import com.lambda.primary.Objects.User.Operations;
import com.lambda.primary.Objects.User.UserRecord;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("user/auth/")
public class AuthenticationController {

    @Autowired
    private Operations operations;
    @Autowired
    private UserServices userServices;

    @Autowired
    private AuthTokenServices authTokenServices;

    @Autowired
    private ConversionService conversionService;

    @PostMapping()
    public String LogIn(
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

    @GetMapping
    public BaseUser authenticate(HttpServletRequest request){

        System.out.println(request.getHeader("user"));

        System.out.println(conversionService.convert(
                request.getHeader("user"),
                BaseUser.class
        ).toString());

        return conversionService.convert(
                request.getHeader("user"),
                BaseUser.class
        );
    }

    @PostMapping("logout/")
    public String LogOut(
            @RequestHeader Map<String,String> headers
            ){
        JSONObject JSON = new JSONObject();
        String username = headers.get("user");
        boolean status = operations.deleteAuthToken(username);

        if(status){
            JSON.put("status","success");
        }else{
            JSON.put("status", "exception");
        }

        return JSON.toString();
    }

}
