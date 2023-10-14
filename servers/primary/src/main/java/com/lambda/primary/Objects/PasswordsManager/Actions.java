package com.lambda.primary.Objects.PasswordsManager;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Models.PasswordsManager.PasswordManagerHandlerModel;
import com.lambda.primary.Services.PasswordsSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Actions {

    @Autowired
    private PasswordsSourceService passwordsSourceService;


    /**
     *
     * @param password fields
     * @param username fields
     * @param user active in the session
     * @return update status
     *
     * :: creates an encrypted entry of the password and the username to the database using the services
     */
    public String createEncryptedEntry(
            String password,
            String username,
            User user
    ){

        try{
            passwordsSourceService.create(
                    encryptPassword_CvX8j(password),
                    username,
                    user.getUserId()
            );
        }catch (Exception e){
            log.info("Unable to create record for {}", user.getUsername());
            return "exception";
        }
        return "success";
    }

    /**
     * @Overload method
     * @param password to be stored
     * @param userPk user id primary key
     * @return status
     */
    public String createEncryptedEntry(
            List<PasswordManagerHandlerModel> password,
            Long userPk
    ){

        try{
            for (PasswordManagerHandlerModel model:
                    password) {
                passwordsSourceService.create(
                        encryptPassword_CvX8j(model.getPassword()),
                        model.getUsername(),
                        userPk
                );
            }
        }catch (Exception e){
            return "exception";
        }
        return "success";
    }

    public String updateUsername(String username, Long entryId){



        return "success";
    }


    /*
    -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */


    /**
     *
     * @param raw password
     * @return encrypted password
     */
    private String encryptPassword_CvX8j(String raw){
        String password;

        //-ToBeImplemented-
        password = "";

        return password;
    }

}
