package com.lambda.primary.ContentExports.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PasswordsSource {

    public PasswordsSource(
            String username,
            String password,
            Long user
    ){
        this.username = username;
        this.password = password;
        this.user = user;
    }


    @Id
    @SequenceGenerator(
            name = "PwdSrc_seq",
            sequenceName = "PwdSrc_seq",
            allocationSize = 1
    )
    private Long Id;

    private String password;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private Long user;

}
