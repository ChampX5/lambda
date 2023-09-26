package com.lambda.primary.CoreExports.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthToken {

    @Id
    private Long Id;


    @OneToOne(targetEntity = User.class,cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn(referencedColumnName = "UserId")
    private User user;

    @Column(
            columnDefinition = "VARCHAR(100)",
            unique = true
    )
    private String token;

    @Column(
            columnDefinition = "DATETIME"
    )
    private LocalDateTime loggedIn;



}
