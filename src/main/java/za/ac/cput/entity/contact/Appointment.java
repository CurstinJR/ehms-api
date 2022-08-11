package za.ac.cput.entity.contact;

import java.time.LocalDate;

/*
Appointment.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */

public class Appointment {
    private Long appointmentId;
    private String appointmentTime;
    private LocalDate appointmentDate;

    private Appointment(Builder builder) {
        this.appointmentId = builder.appointmentId;
        this.appointmentTime = builder.appointmentTime;
        this.appointmentDate = builder.appointmentDate;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
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

    public static class Builder {
        private Long appointmentId;
        private String appointmentTime;
        private LocalDate appointmentDate;

        public Builder appointmentId(Long appointmentId) {
            this.appointmentId = appointmentId;
            return this;
        }

        public Builder appointmentTime(String appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }

        public Builder appointmentDate(LocalDate appointmentDate) {
            this.appointmentDate = appointmentDate;
            return this;
        }

        public Builder copy(Appointment appointment) {
            this.appointmentId = appointment.appointmentId;
            this.appointmentTime = appointment.appointmentTime;
            this.appointmentDate = appointment.appointmentDate;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }
    }
}
