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
        Role role = new Role.Builder().setRoleId(RoleId)
                .setRoleName(roleName).setRoleDescription(roleDescription).build();
        return role;
    }
}
