package com.lambda.primary.CoreExports.repos;

import com.lambda.primary.CoreExports.entities.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {


    boolean existsById(Long Id);

    @Query(
            value = "SELECT * FROM authtoken",
            nativeQuery = true
    )
    List<AuthToken> queryAllTokens();

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
    @Modifying
    void queryDeleteTokenFromId(@Param("value") Long Id);

}
