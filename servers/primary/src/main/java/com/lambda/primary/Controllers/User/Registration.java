package com.lambda.primary.Controllers.User;

import com.lambda.primary.Objects.User.Operations;
import com.lambda.primary.Objects.User.RegistrationRecord;
import com.lambda.primary.Services.UserServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/register/")
public class Registration {

    @Autowired
    private UserServices userService;
    @Autowired
    private Operations userOperations;

    @PostMapping
    public String register(
            @RequestBody RegistrationRecord record
    ) {
        List<String> validateFields = userOperations.validateRegistration(record);
        if (validateFields != null) {
            return new JSONObject()
                    .put("registration_status", "denied")
                    .put("details",
                            validateFields
                    ).toString();
        }
        return new JSONObject()
                .put("registration_status", "success")
                .toString();

    }

}
