package za.ac.cput.factory;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.LoginCredentials;

public class EmployeeFactory {

    public static Employee createEmployee (Long employeeId, String employeeName, String employeeSurname){
        return new Employee.Builder().employeeId(employeeId)
                .employeeName(employeeName)
                .employeeSurname(employeeSurname)
                .build();
    }
}
