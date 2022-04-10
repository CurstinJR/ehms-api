package za.ac.cput.repository.impl;

import za.ac.cput.entity.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/*
EmployeeRepository.java
Author: Tarren-Marc Adams - 214041794
Date: 10 April 2022
 */

public class EmployeeRepository implements IEmployeeRepository{

    private static EmployeeRepository employeeRepository = null;

    private Collection<Employee> employeeDB = null;

    private EmployeeRepository()
    {
        employeeDB = new ArrayList<>();
    }

    public static EmployeeRepository getEmployeeRepository()
    {
        return employeeRepository == null ?
                employeeRepository = new EmployeeRepository() :
                employeeRepository;
    }

    @Override
    public Employee save(Employee employee)
    {
        employeeDB.add(employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(Long employeeId)
    {
        Employee employee = employeeDB.stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(employee);
    }

    @Override
    public Collection<Employee> findAll()

    {
        return employeeDB;
    }

    @Override
    public Employee update(Employee employee)
    {
        Long employeeId = employee.getEmployeeId();
        Employee oldEmployee = findById(employeeId).orElseThrow();
        employeeDB.remove(oldEmployee);
        employeeDB.add(employee);

        return employee;
    }

    @Override
    public boolean deleteById(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employeeDB.remove(employee);
        return true;
    }

    @Override
    public boolean existsById(Long employeeId)
    {
        employeeDB.stream().
                anyMatch(employee -> employee.getEmployeeId().equals(employeeId));
        return true;
    }
}
