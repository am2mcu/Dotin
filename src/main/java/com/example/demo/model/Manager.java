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
@DiscriminatorValue("Manager")
public class Manager extends User {
}
