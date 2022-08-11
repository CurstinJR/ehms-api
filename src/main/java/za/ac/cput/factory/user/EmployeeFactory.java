package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.util.Helper;

/*
EmployeeFactory.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class EmployeeFactory {

    public static Employee createEmployee(String employeeName, String employeeSurname) {

        Long employeeId = Helper.generateId();

        return new Employee.Builder().employeeId(employeeId)
                .employeeName(employeeName)
                .employeeSurname(employeeSurname)
                .build();
    }
}
