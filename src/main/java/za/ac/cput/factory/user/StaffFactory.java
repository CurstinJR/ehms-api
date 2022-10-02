package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Role;
import za.ac.cput.entity.user.Staff;

/*
EmployeeFactory.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class StaffFactory {
    public static Staff createStaff(Long id, String firstName, String lastName, Role role) {
        return Staff.builder().id(id)
                .firstName(firstName)
                .lastName(lastName)
                .role(role)
                .build();
    }
}
