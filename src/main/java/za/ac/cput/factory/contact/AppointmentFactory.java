package za.ac.cput.factory.contact;

import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.entity.user.Patient;

import java.time.LocalDate;

/*
AppointmentFactory.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class AppointmentFactory {

    public static Appointment createAppointment(Long appointmentId, String appointmentTime, LocalDate appointmentDate,
                                                Patient patient) {
        return Appointment
                .builder()
                .appointmentId(appointmentId)
                .appointmentTime(appointmentTime)
                .appointmentDate(appointmentDate)
                .patient(patient)
                .build();
    }
}
