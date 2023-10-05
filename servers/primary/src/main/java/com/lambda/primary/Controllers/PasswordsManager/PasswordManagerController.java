package com.lambda.primary.Controllers.PasswordsManager;

import com.lambda.primary.Objects.Passwords.PasswordRecord;
import com.lambda.primary.Validators.IsAuthenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("user/passwords/")
public class PasswordManagerController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @IsAuthenticated
    public String ping(
            @RequestHeader Map<String,String>headers
    ){
        return "success";
    }

    @PostMapping("update/")
    public String update(@RequestBody PasswordRecord header){
        String username =  header.username();
        String password = header.password();


        return "success";
    }

}
