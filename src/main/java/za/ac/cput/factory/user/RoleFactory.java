package za.ac.cput.factory.user;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */

import za.ac.cput.entity.user.Role;
import za.ac.cput.util.Helper;

public class RoleFactory {


    public static Role createRole(String roleName, String roleDescription) {
        Long RoleId = Helper.generateId();
        Role role = Role.builder().roleId(RoleId)
                .roleName(roleName).roleDescription(roleDescription).build();
        return role;
    }
}
