package com.example.demo.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    private String username, password;
    private String firstName, lastName;
    private String email;
}
