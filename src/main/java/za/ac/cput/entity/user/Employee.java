package za.ac.cput.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
Employee.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class Employee extends BaseUser {
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
