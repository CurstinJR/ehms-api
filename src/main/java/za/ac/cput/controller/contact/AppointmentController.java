package za.ac.cput.controller.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.contact.impl.AppointmentServiceImpl;

import java.util.List;

/*
AppointmentController.java
Author: Tarren-Marc Adams - 214041794
Date: 6/10/2022
 */

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;

    @Autowired
    public AppointmentController(AppointmentServiceImpl appointmentService){this.appointmentService=appointmentService;}

    @GetMapping
    public ResponseEntity<List<Appointment>> getAppointments() {
        List<Appointment> appointments = appointmentService.findAll();
        return ResponseEntity.ok(appointments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAppointmentById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Appointment appointment = appointmentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(appointment);
    }
    @PostMapping
    public ResponseEntity<Appointment> addAppointment(@RequestBody final Appointment appointment) {
        Appointment saveAppointment = appointmentService.save(appointment);
        return new ResponseEntity<>(saveAppointment, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointmentById(@PathVariable final Long id,
                                                       @RequestBody final Appointment appointment) {
        String notFoundMessage = getNotFoundMessage(id);
        Appointment updateAppointment = appointmentService.update(id, appointment)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updateAppointment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable final Long id) {
        if (!appointmentService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Appointment with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
