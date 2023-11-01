package com.lambda.primary.Services;

import com.lambda.primary.ContentExports.entities.PasswordsSource;
import com.lambda.primary.ContentExports.repos.PasswordsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordsSourceService {

    @Autowired
    private PasswordsSourceRepository passwordsSourceRepository;


    /**
     *
     * @param passwordsSource
     */
    public void create(PasswordsSource passwordsSource){
        passwordsSourceRepository.save(passwordsSource);
    }

    /**
     *
     * @param hashedPassword -> updatable
     * @param username -> updatable
     * @param user -> User id (pk)
     */
    public void create(String hashedPassword, String username, Long user){
        passwordsSourceRepository.save(
                new PasswordsSource(
                        username,
                        hashedPassword,
                        user
                )
        );
    }

}
