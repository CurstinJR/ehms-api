package za.ac.cput.factory;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
import za.ac.cput.entity.Role;
import za.ac.cput.util.Helper;

public class RoleFactory {


    public static Role createRole(String roleName, String roleDescription)
    {
        Long RoleId= Helper.generateID();
        Role role =new Role.Builder().setRoleId(RoleId)
                .setRoleName(roleName).setRoleDescription(roleDescription).Build();
        return  role;
    }
}
