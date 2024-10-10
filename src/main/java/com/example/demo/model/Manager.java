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
@Table(name = "managers")
@DiscriminatorValue("MANAGER")
public class Manager extends User {
    public Manager(String username, String password, String email) {
        super(username, password, email);
    }
}
