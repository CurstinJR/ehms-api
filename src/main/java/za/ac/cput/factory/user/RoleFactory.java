package za.ac.cput.factory.user;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */

import za.ac.cput.entity.user.Role;

public class RoleFactory {
    public static Role createRole(Long id, String name, String description) {
        return Role.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }
}
