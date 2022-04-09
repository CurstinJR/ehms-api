package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void testEquality() {
        Employee employee1 = EmployeeFactory.createEmployee(1L,"Lito","Oosthuizen");
        Employee employee2 = EmployeeFactory.createEmployee(2L,"Carey","Koopman");
        Employee employee3 = employee1;

        assertEquals(employee1,employee3);
        assertNotEquals(employee1,employee2);
    }

    @Test
    void testIdentity(){
        Employee employee1 = EmployeeFactory.createEmployee(1L,"Lito","Oosthuizen");
        Employee employee2 = EmployeeFactory.createEmployee(2L,"Carey","Koopman");
        Employee employee3 = employee1;

        assertSame(employee1,employee3);
        assertSame(employee1.getEmployeeId(),employee3.getEmployeeId());
        assertNotSame(employee1,employee2);
        assertNotSame(employee3.getEmployeeId(),employee2.getEmployeeId());
    }

}