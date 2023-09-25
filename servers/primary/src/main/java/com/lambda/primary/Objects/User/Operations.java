package com.lambda.primary.Objects.User;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Services.AuthTokenServices;
import com.lambda.primary.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.SecureRandomParameters;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class Operations {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserServices userServices;
    @Autowired
    private AuthTokenServices authTokenServices;

    public User authenticate(String password, String username) {
        //Validates on existence of username in database
        if (!userServices.existsByUsername(username)) {
            return null;
        }

        //validation on password matches
        String hashedPassword = userServices.fetchPasswordOnUsername(username);
        if (encoder.matches(
                password,
                hashedPassword
        )) {
            return userServices.fetchUserOnUsername(username);
        }

        return null;
    }

    public String generateAuthToken(User user) throws NoSuchAlgorithmException {
        //Authenticating user

        //performance improvement!!
        if (!preTokenGenerationTest(user.getPassword(), user.getUsername())) return null;
        
        //generating token
        byte[] bytesToken = new byte[30];
        SecureRandom.getInstanceStrong().nextBytes(bytesToken);
        String authToken = Base64.getUrlEncoder().withoutPadding().encodeToString(bytesToken);

        //registering authtoken
        authTokenServices.createAuthToken(user, authToken);
        return authToken;
    }


    /**
     *
     * @param registrationRecord
     * @return List<String>
     *     if null -> validation successful
     *     else -> validation unsuccessful returns list of unauthorized fields
     *
     * ::Validates registration and adds the user to the database
     */
    public List<String> validateRegistration(RegistrationRecord registrationRecord) {
        List<String> validationDeniedFields = new ArrayList<>();

        String email = registrationRecord.email();
        String username = registrationRecord.username();

        if (userServices.existsByEmail(email)) validationDeniedFields.add("email");
        if (userServices.existsByUsername(username)) validationDeniedFields.add("username");

        //If all validations success => validationDeniedFields will be empty
        if (validationDeniedFields.isEmpty()) {

            //generating hashed password
            String encodedPwd = encoder.encode(registrationRecord.password());

            userServices.addUser(
                    registrationRecord.username(),
                    encodedPwd,
                    registrationRecord.firstName(),
                    registrationRecord.lastName(),
                    registrationRecord.telephone(),
                    registrationRecord.email()
            );
            return null;
        }

        return validationDeniedFields;
    }

    private boolean preTokenGenerationTest(String password, String username){
        //Validates on existence of username in database
        if (!userServices.existsByUsername(username)) {
            return false;
        }

        //validation on password matches
        return userServices.fetchPasswordOnUsername(username).equals(password);
    }


}