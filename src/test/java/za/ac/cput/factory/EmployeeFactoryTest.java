package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void addEmployeeTest1(){
        // test if employee can be created
        Employee employee = EmployeeFactory.createEmployee(3L,"Lyle","Adams");
        assertNotNull(employee);
        System.out.println("employee has been added");
    }

}