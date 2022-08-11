package za.ac.cput.entity.user;

/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
public class Role {

    private final Long roleId;
    private final String roleName;
    private final String roleDescription;

    public Role(Role.Builder builder) {
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
        this.roleDescription = builder.roleDescription;

    }

    public Long getRoleId() {
        return roleId;
    }

    public String roleName() {
        return roleName;
    }

    public String roleDescription() {
        return roleDescription;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }

    public static class Builder {
        private Long roleId;
        private String roleName;
        private String roleDescription;

        public Role.Builder setRoleId(Long roleId) {
            this.roleId = roleId;
            return this;
        }

        public Role.Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Role.Builder setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }

        public Role.Builder copy(Role role) {
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            this.roleDescription = role.roleDescription;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }


}
