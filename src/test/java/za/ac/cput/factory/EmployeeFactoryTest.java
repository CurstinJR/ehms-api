package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.entity.user.Role;
import za.ac.cput.factory.user.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
EmployeeFactoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

class EmployeeFactoryTest {

    @Test
    public void addEmployeeTest1() {
        // test if employee can be created
        Role role = new Role(1L, "ADMIN", "Root user");
        Employee employee = EmployeeFactory.createEmployee(1L, "lyle", "Adams", role);
        assertNotNull(employee);
        System.out.println("employee has been added");
    }

    @Test
    void testEquality() {
        Role role1 = new Role(1L, "ADMIN", "Root user");
        Employee employee1 = EmployeeFactory.createEmployee(1L, "lyle", "Adams", role1);
        Role role2 = new Role(2L, "ADMIN", "Normal user");
        Employee employee2 = EmployeeFactory.createEmployee(2L, "lyle", "Adams", role2);
        Employee employee3 = employee1;

        assertEquals(employee1, employee3);
        assertNotEquals(employee1, employee2);
    }

    @Test
    void testIdentity() {
        Role role1 = new Role(1L, "ADMIN", "Root user");
        Employee employee1 = EmployeeFactory.createEmployee(1L, "lyle", "Adams", role1);
        Role role2 = new Role(2L, "ADMIN", "Normal user");
        Employee employee2 = EmployeeFactory.createEmployee(2L, "lyle", "Adams", role2);
        Employee employee3 = employee1;

        assertSame(employee1, employee3);
        assertSame(employee1.getId(), employee3.getId());
        assertNotSame(employee1, employee2);
        assertNotSame(employee3.getId(), employee2.getId());
    }

}