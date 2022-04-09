package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.App;
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

    @Test
    void testEquality(){
        Appointment appointment1 = AppointmentFactory.createApppointment(12L,"14:00", LocalDate.ofEpochDay(04-07-2011));
        Appointment appointment2 = AppointmentFactory.createApppointment(13L,"14:00", LocalDate.ofEpochDay(04-07-2011));
        Appointment appointment3 = appointment1;

        assertEquals(appointment1,appointment3);
        assertNotEquals(appointment1,appointment2);
    }

    @Test
    void testIdentity(){
        Appointment appointment1 = AppointmentFactory.createApppointment(12L,"14:00", LocalDate.ofEpochDay(04-07-2011));
        Appointment appointment2 = AppointmentFactory.createApppointment(13L,"10:00", LocalDate.ofEpochDay(04-07-2011));
        Appointment appointment3 = appointment1;

        assertSame(appointment1,appointment3);
        assertSame(appointment1.getAppointmentDate(),appointment3.getAppointmentDate());

        assertNotSame(appointment1,appointment2);
        assertNotSame(appointment1.getAppointmentTime(),appointment2.getAppointmentTime());
    }
}