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
@Table(name = "customers")
@DiscriminatorValue("Customer")
public class Customer extends User {
    private String firstName;
    private String lastName;

    public Customer(String username, String password, String email, String firstName, String lastName) {
        super(username, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
