package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;

import java.time.LocalDate;

/*
Appointment.java
Author: Tarren-Marc Adams - 214041794
Date: 9 April 2022
 */

public class AppointmentFactory {

    public static Appointment createApppointment (Long appointmentId, String appointmentTime, LocalDate appointmentDate){
        return new Appointment.Builder().appointmentId(appointmentId)
                .appointmentTime(appointmentTime)
                .appointmentDate(appointmentDate)
                .build();
    }
}
