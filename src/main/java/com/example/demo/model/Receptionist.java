package com.example.demo.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "receptionists")
@DiscriminatorValue("RECEPTIONIST")
public class Receptionist extends User {
    public Receptionist(String username, String password, String email) {
        super(username, password, email);
    }
}
