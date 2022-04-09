package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Appointment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    public void addAppointment(){
        Appointment appointment1 = AppointmentFactory.createApppointment(7L, "15:00", LocalDate.ofEpochDay(21-04-22));
        assertNotNull(appointment1);
        System.out.println("Appointment created");

    }



}