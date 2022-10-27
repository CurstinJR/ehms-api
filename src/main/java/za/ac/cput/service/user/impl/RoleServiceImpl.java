package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Role;
import za.ac.cput.repository.user.RoleRepository;
import za.ac.cput.service.user.IRoleService;

import java.util.List;
import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * RoleServiceImpl.java
 * 2022/10/28
 */
@Service
public class RoleServiceImpl implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> update(Long id, Role newRole) {
        return findById(id).map(role -> {
            String name = newRole.getName();
            String description = newRole.getDescription();
            role = new Role(id, name, description);
            return save(role);
        });
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return roleRepository.existsById(id);
    }
}
