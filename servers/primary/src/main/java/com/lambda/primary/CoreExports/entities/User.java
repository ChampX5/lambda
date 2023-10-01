package com.lambda.primary.CoreExports.entities;

import com.lambda.primary.Objects.User.Permissions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(
            sequenceName = "user_id_seq",
            name = "user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq"
    )
    private  Long UserId;


    @Column(
            columnDefinition = "VARCHAR(40)",
            nullable = false,
            updatable = false
    )
    private String username;

    @Column(
            length = 100,
            nullable = false
    )
    private String password;


    @Column(
            length = 20
    )
    private String first_name;

    @Column(
            length = 20
    )
    private String last_name;

    @Enumerated(EnumType.STRING)
    private Permissions userPermission;
    @Column(
            unique = true,
            updatable = false,
            length = 100
    )
    private String email;
    @Column(
            length = 15
    )
    private Long telephone;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime joinedDate;

    @ColumnDefault(value = "0")
    private Boolean rememberUser;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AuthToken authToken;

}
