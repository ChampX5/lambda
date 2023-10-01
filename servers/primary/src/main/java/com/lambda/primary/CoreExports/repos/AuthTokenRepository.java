package com.lambda.primary.CoreExports.repos;

import com.lambda.primary.CoreExports.entities.AuthToken;
import com.lambda.primary.CoreExports.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {

    @Query(
            value = "SELECT * FROM authtoken WHERE token=:token",
            nativeQuery = true
    )
    AuthToken queryAuthTokenFromToken(@Param("token") String token);

    @Query(
            value = "SELECT * FROM authtoken WHERE token=:token",
            nativeQuery = true
    )
    public List<AuthToken> queryIdFromToken(@Param("token") String token);

    @Query(
            value = "DELETE FROM authtoken WHERE Id=:value",
            nativeQuery = true
    )
    void queryDeleteTokenFromId(@Param("value") Long Id);
}
