package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.Role;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.user.impl.RoleServiceImpl;

import java.util.List;

/**
 * @Author Curstin Rose - 220275408
 * RoleController.java
 */
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleServiceImpl roleService;

    @Autowired
    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        List<Role> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Role role = roleService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<Role> addRole(@RequestBody final Role role) {
        Role saveEmployee = roleService.save(role);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRoleById(@PathVariable final Long id,
                                               @RequestBody final Role role) {
        String notFoundMessage = getNotFoundMessage(id);
        Role updateRole = roleService.update(id, role)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateRole);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoleById(@PathVariable final Long id) {
        if (!roleService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Role with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
