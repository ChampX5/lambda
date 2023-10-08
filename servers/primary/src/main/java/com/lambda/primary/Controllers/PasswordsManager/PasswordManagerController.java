package com.lambda.primary.Controllers.PasswordsManager;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lambda.primary.Models.PasswordsManager.PasswordManagerHandlerModel;
import com.lambda.primary.Models.PasswordsManager.PasswordModel;
import com.lambda.primary.Validators.IsAuthenticated;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public String update(@RequestBody PasswordModel header){
        String username =  header.username();
        String password = header.password();


        return "success";
    }

    @PutMapping()
    @IsAuthenticated
    public String put(
            @RequestHeader Map<String, String> headers,
            @RequestBody ObjectNode bodyObject
            ){


        JsonNode JSON =  bodyObject.get("pwds_list");
        System.out.println(JSON.toString());
       Iterator<JsonNode> JSONIterator =
               JSON.iterator();
       List<PasswordManagerHandlerModel> pwdModelList =
               new ArrayList<>();

       /*
       while (JSONIterator.hasNext()){
           /*
           pwdModelList.add(
                   new PasswordManagerHandlerModel(
                           JSONIterator.next().get("username").toString(),
                           JSONIterator.next().get("password").toString()
                   )
           );

           JSONIterator.next().

           System.out.println(JSONIterator.next().get("username").toString());
       }
       */

        for (JsonNode node:
             JSON) {

            pwdModelList.add(
                    new PasswordManagerHandlerModel(
                            node.get("username").toString(),
                            node.get("password").toString()
                    )
            );

            System.out.println(node.get("password"));
            System.out.println(node.get("username"));
        }


        return new JSONObject().put("insertion_status","success").toString();
    }

}
