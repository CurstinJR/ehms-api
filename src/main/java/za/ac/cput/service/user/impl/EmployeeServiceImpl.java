package za.ac.cput.service.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.entity.user.Role;
import za.ac.cput.factory.user.EmployeeFactory;
import za.ac.cput.repository.user.EmployeeRepository;
import za.ac.cput.service.user.IEmployeeService;
import java.util.List;
import java.util.Optional;

/*
EmployeeServiceImpl.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee save(Employee employee){return employeeRepository.save(employee);}

    @Override
    public Optional<Employee> update(Long id, Employee newEmployee) {
        return findById(id).map(employee -> {
            String firstName = newEmployee.getFirstName();
            String lastName = newEmployee.getLastName();
            Role role = newEmployee.getRole();
            employee = EmployeeFactory.createEmployee(id, firstName, lastName, role);
            return save(employee);
        });
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }
}
