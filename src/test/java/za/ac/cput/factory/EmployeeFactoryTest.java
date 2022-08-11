package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.factory.user.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
EmpoyeeFactoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

class EmployeeFactoryTest {

    @Test
    public void addEmployeeTest1() {
        // test if employee can be created
        Employee employee = EmployeeFactory.createEmployee("lyle", "Adams");
        assertNotNull(employee);
        System.out.println("employee has been added");
    }

    @Test
    void testEquality() {
        Employee employee1 = EmployeeFactory.createEmployee("Lito", "Oosthuizen");
        Employee employee2 = EmployeeFactory.createEmployee("Carey", "Koopman");
        Employee employee3 = employee1;

        assertEquals(employee1, employee3);
        assertNotEquals(employee1, employee2);
    }

    @Test
    void testIdentity() {
        Employee employee1 = EmployeeFactory.createEmployee("Lito", "Oosthuizen");
        Employee employee2 = EmployeeFactory.createEmployee("Carey", "Koopman");
        Employee employee3 = employee1;

        assertSame(employee1, employee3);
        assertSame(employee1.getEmployeeId(), employee3.getEmployeeId());
        assertNotSame(employee1, employee2);
        assertNotSame(employee3.getEmployeeId(), employee2.getEmployeeId());
    }

}