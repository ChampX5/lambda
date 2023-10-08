package com.lambda.primary.Models.PasswordsManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Serializable object to transfer passwordsSource entity data
 */
@AllArgsConstructor
@Getter
@Setter
public class PasswordManagerHandlerModel{

    String username;
    String password;

}
