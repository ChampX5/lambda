package com.lambda.primary.Objects.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public record UserRecord(String username, String password) {
}
