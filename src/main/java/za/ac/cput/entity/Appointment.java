package za.ac.cput.entity;

import java.util.Date;

/*
Appointment.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */

public class Appointment {
    private Long appointmentId;
    private String appointmentTime;
    private Date appointmentDate;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
