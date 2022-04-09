package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;

import java.time.LocalDate;


public class AppointmentFactory {

    public static Appointment createApppointment (Long appointmentId, String appointmentTime, LocalDate appointmentDate){
        return new Appointment.Builder().appointmentId(appointmentId)
                .appointmentTime(appointmentTime)
                .appointmentDate(appointmentDate)
                .build();
    }
}
