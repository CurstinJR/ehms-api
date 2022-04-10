package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/*
EmployeeRepositoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 10 April 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {
    private static EmployeeRepository employeeRepository = EmployeeRepository.getEmployeeRepository();
    private static Employee employee1 = EmployeeFactory.createEmployee("Lito","Adams");

    @Test()
    @Order(1)
    //Test 1
    void getEmployeeRepository()
    {
        EmployeeRepository employeeRepository1 = EmployeeRepository.getEmployeeRepository();

        assertEquals(employeeRepository1.hashCode(), employeeRepository.hashCode());
    }

    @Test()
    @Order(2)
    //Test save
    void save()
    {
        Employee saveEmployee = employeeRepository.save(employee1);
        assertEquals(employee1.getEmployeeId(),saveEmployee.getEmployeeId());

    }

    @Test()
    @Order(3)
    //Test findById
    void findById()
    {
        Employee employee = employeeRepository
                .findById(employee1.getEmployeeId())
                .orElseThrow();
        assertNotNull(employee);

    }
    @Test
    @Order(4)
    // test findAll
    void findAll()
    {
        Collection<Employee> employee = employeeRepository.findAll();
        assertEquals(1, employee.size());
    }

    @Test
    @Order(5)
    // test update
    void update()
    {
        Long employeeId = employee1.getEmployeeId();
        String employeeName = employee1.getEmployeeName();

        employee1.setEmployeeName("Armin");
        Employee updateEmployee = employeeRepository.update(employee1);

        assertEquals(employeeId, updateEmployee.getEmployeeId());
        assertNotEquals(employeeName, updateEmployee.getEmployeeName());
        assertEquals(employee1, updateEmployee);
    }

    @Test
    @Order(6)
    // test if employee existsById
    void existsById()
    {
        boolean employee = employeeRepository.existsById(employee1.getEmployeeId());

        assertTrue(employee);
    }

    @Test
    @Order(7)
    // test delete employee
    void delete()
    {
        employeeRepository.deleteById(employee1.getEmployeeId());

        assertTrue(employeeRepository.findAll().isEmpty());
    }

}