package za.ac.cput.service.contact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.factory.contact.AppointmentFactory;
import za.ac.cput.repository.contact.AppointmentRepository;
import za.ac.cput.service.contact.IAppointmentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/*
AppointmentServiceImpl.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> update(Long id, Appointment newAppointment) {
        return findById(id).map(appointment -> {
            String appointmentTime = newAppointment.getAppointmentTime();
            LocalDate appointmentDate = newAppointment.getAppointmentDate();
            appointment = AppointmentFactory.createAppointment(id, appointmentTime, appointmentDate);
            return save(appointment);
        });
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }


    @Override
    public boolean existsById(Long id) {
        return appointmentRepository.existsById(id);
    }
}
