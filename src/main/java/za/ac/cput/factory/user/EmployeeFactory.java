package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.entity.user.Role;

/*
EmployeeFactory.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class EmployeeFactory {
    public static Employee createEmployee(Long id, String firstName, String lastName, Role role) {
        return Employee.builder().id(id)
                .firstName(firstName)
                .lastName(lastName)
                .role(role)
                .build();
    }
}
