package za.ac.cput.service.user;

import za.ac.cput.entity.user.Role;
import za.ac.cput.service.IService;

public interface IRoleService extends IService<Role, Long> {
    boolean existsById(Long id);
}
