package za.ac.cput.service.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.service.IService;

/*
IEmployeeService.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

public interface IEmployeeService extends IService<Employee, Long> {
    boolean existsById(Long id);
}
