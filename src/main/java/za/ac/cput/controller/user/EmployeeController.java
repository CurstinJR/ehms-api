package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.user.impl.EmployeeServiceImpl;

import java.util.List;

/*
EmployeeController.java
Author: Tarren-Marc Adams - 214041794
Date: 6/10/2022
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Employee employee = employeeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody final Employee employee) {
        Employee saveEmployee = employeeService.save(employee);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable final Long id,
                                                       @RequestBody final Employee employee) {
        String notFoundMessage = getNotFoundMessage(id);
        Employee updateEmployee = employeeService.update(id, employee)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable final Long id) {
        if (!employeeService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Employee with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
