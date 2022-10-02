package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Role;
import za.ac.cput.entity.user.Staff;
import za.ac.cput.factory.user.StaffFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
EmpoyeeFactoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

class StaffFactoryTest {

    @Test
    public void addStaffTest1() {
        // test if staff can be created
        Role role = new Role(1L, "ADMIN", "Root user");
        Staff staff = StaffFactory.createStaff(1L, "lyle", "Adams", role);
        assertNotNull(staff);
        System.out.println("staff has been added");
    }

    @Test
    void testEquality() {
        Role role1 = new Role(1L, "ADMIN", "Root user");
        Staff staff1 = StaffFactory.createStaff(1L, "lyle", "Adams", role1);
        Role role2 = new Role(2L, "ADMIN", "Normal user");
        Staff staff2 = StaffFactory.createStaff(2L, "lyle", "Adams", role2);
        Staff staff3 = staff1;

        assertEquals(staff1, staff3);
        assertNotEquals(staff1, staff2);
    }

    @Test
    void testIdentity() {
        Role role1 = new Role(1L, "ADMIN", "Root user");
        Staff staff1 = StaffFactory.createStaff(1L, "lyle", "Adams", role1);
        Role role2 = new Role(2L, "ADMIN", "Normal user");
        Staff staff2 = StaffFactory.createStaff(2L, "lyle", "Adams", role2);
        Staff staff3 = staff1;

        assertSame(staff1, staff3);
        assertSame(staff1.getId(), staff3.getId());
        assertNotSame(staff1, staff2);
        assertNotSame(staff3.getId(), staff2.getId());
    }

}