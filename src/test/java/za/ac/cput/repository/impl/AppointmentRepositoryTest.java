package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Appointment;

import za.ac.cput.factory.AppointmentFactory;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/*
AppointmentRepositoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 10 April 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentRepositoryTest {
    private static AppointmentRepository appointmentRepository = AppointmentRepository.getAppointmentRepository();
    private static Appointment appointment1 = AppointmentFactory.createApppointment("14:00",
            LocalDate.of(2022,01,25));

    @Test
    @Order(1)
    void getAppointmentRepository()
    {
        AppointmentRepository appointmentRepository1 = AppointmentRepository.getAppointmentRepository();

        assertEquals(appointmentRepository1.hashCode(), appointmentRepository.hashCode());
    }

    @Test
    @Order(2)
    void save()
    {
        Appointment savedAppointment = appointmentRepository.save(appointment1);
        Long patientId = savedAppointment.getAppointmentId();

        assertEquals(patientId, appointment1.getAppointmentId());
    }

    @Test
    @Order(3)
    void findById()
    {
        Appointment appointment = appointmentRepository
                .findById(appointment1.getAppointmentId())
                .orElseThrow();

        assertNotNull(appointment);
    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<Appointment> appointments = appointmentRepository.findAll();
        assertEquals(1, appointments.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long appointmentId = appointment1.getAppointmentId();
        String appoinmentTime = appointment1.getAppointmentTime();


        appointment1.setAppointmentTime("15:00");
        Appointment updateAppointment = appointmentRepository.update(appointment1);

        assertEquals(appointmentId, updateAppointment.getAppointmentId());
        assertNotEquals(appoinmentTime, updateAppointment.getAppointmentTime());
        assertEquals(appointment1, updateAppointment);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean appointmentExists = appointmentRepository.existsById(appointment1.getAppointmentId());

        assertTrue(appointmentExists);
    }

    @Test
    @Order(7)
    void deleteById()
    {
        appointmentRepository.deleteById(appointment1.getAppointmentId());

        assertTrue(appointmentRepository.findAll().isEmpty());
    }
}