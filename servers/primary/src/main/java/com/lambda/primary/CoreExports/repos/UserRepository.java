package com.lambda.primary.CoreExports.repos;

import com.lambda.primary.CoreExports.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


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



}
