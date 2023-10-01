package com.lambda.primary.Services;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.CoreExports.repos.UserRepository;
import com.lambda.primary.Objects.User.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;
    @Transactional
    public void addUser(User user){
        userRepository.save(
                user
        );
    }


    public User fetchUserOnUserId(Long userId){
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public User fetchUserOnUsername(String username){
        Optional<User>user =  userRepository.findByUsername(username);
        return user.orElse(null);
    }

    public String fetchPasswordOnUsername(String username){
        return userRepository.queryPasswordFromUsername(username);
    }
    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void addUser(
            String username, String password,String firstName,
            String lastName, Long telephone, String email){
        User user = User.builder()
                .userPermission(Permissions.IS_USER)
                .last_name(lastName)
                .joinedDate(LocalDateTime.now())
                .first_name(firstName)
                .telephone(telephone)
                .password(password)
                .username(username)
                .email(email)
                .build();

        userRepository.save(user);
    }

    public Permissions getUserPermsByUsername(String username){
        return userRepository.queryPermissionsFromUsername(username);
    }

    public Long fetchIdOnUsername(String username){
        return userRepository.queryIdFromUsername(username);
    }


}
