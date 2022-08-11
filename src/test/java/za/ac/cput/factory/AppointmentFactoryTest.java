package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.factory.contact.AppointmentFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
AppointmentFactoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

class AppointmentFactoryTest {

    @Test
    public void addAppointment() {
        Appointment appointment1 = AppointmentFactory.createApppointment("15:00", LocalDate.ofEpochDay(21 - 04 - 22));
        assertNotNull(appointment1);
        System.out.println("Appointment created");
    }

    @Test
    void testEquality() {
        Appointment appointment1 = AppointmentFactory.createApppointment("14:00", LocalDate.of(2022, 03, 12));
        Appointment appointment2 = AppointmentFactory.createApppointment("14:00", LocalDate.of(2022, 04, 1));
        Appointment appointment3 = appointment1;

        assertEquals(appointment1, appointment3);
        assertNotEquals(appointment1, appointment2);
    }

    @Test
    void testIdentity() {
        Appointment appointment1 = AppointmentFactory.createApppointment("14:00", LocalDate.of(2022, 3, 12));
        Appointment appointment2 = AppointmentFactory.createApppointment("15:00", LocalDate.of(2022, 4, 1));
        Appointment appointment3 = appointment1;

        assertSame(appointment1, appointment3);
        assertSame(appointment1.getAppointmentDate(), appointment3.getAppointmentDate());

        assertNotSame(appointment1, appointment2);
        assertNotSame(appointment1.getAppointmentTime(), appointment2.getAppointmentTime());
    }
}