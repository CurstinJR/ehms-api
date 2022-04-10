package za.ac.cput.repository;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Prescription;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.PrescriptionFactory;
import za.ac.cput.factory.RoleFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class RoleRepositoryTest {
    private static RoleRepository repository= RoleRepository.getRepository();
    private static Role role= RoleFactory.createRole("Founder","a person who creates or establishes something");

    @Test
    void a_save() {
        Role created =repository.save(role);
        assertEquals(role.getRoleId(),created .getRoleId());
        System.out.println("created"+created);
    }

    @Test
    void b_findById() {
        Role created =repository.save(role);
        Optional<Role> READ =repository.findById(role.getRoleId());
        assertNotNull(READ);
        System.out.println("  findById "+READ);
    }

    @Test
    void c_update() {
        Role created =repository.save(role);
        Role update= new Role.Builder().cody(role).setRoleName("Manager").setRoleDescription("A manager is a professional who takes a leadership role in an organisation and manages a team of employees").Build();
        assertNotNull(repository.update(update,update.getRoleId()));
        System.out.println("updated"+update);
    }

    @Test
    void g_delete() {
    }

    @Test
    void d_existsById() {
        Role created =repository.save(role);
        boolean success=repository.existsById(role.getRoleId());
        assertTrue(success);
        System.out.println("existsById "+success);
    }

    @Test
    void f_getAll() {
        Role created =repository.save(role);
        assertNotNull(repository.getAll());
        System.out.println("List"+repository.getAll());
    }
}