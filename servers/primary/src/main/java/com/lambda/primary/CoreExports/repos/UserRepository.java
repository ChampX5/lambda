package com.lambda.primary.CoreExports.repos;

import com.lambda.primary.CoreExports.entities.User;
import com.lambda.primary.Objects.User.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);
    boolean existsByEmail(String username);
    boolean existsByUsername(String username);

    @Query(
            value = "SELECT password FROM user WHERE username=:usernameParse",
            nativeQuery = true
    )
    String queryPasswordFromUsername(@Param("usernameParse")String usernameParse);

    @Query(
            value = "SELECT permission FROM user WHERE username:usernameParse LIMIT 1",
            nativeQuery = true
    )
    Permissions queryPermissionsFromUsername(@Param("usernameParse")String usernameParse);

    @Query(
        value = "SELECT UserId FROM user WHERE username = :value LIMIT 1",
            nativeQuery = true
    )
    Long queryIdFromUsername(@Param("value") String username);


    @Query(
            value = "SELECT * FROM user",
            nativeQuery = true
    )
    List<User> queryAllUsers();


}
