package za.ac.cput.api.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.contact.Appointment;
import za.ac.cput.entity.user.Patient;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.contact.impl.AppointmentServiceImpl;
import za.ac.cput.service.user.impl.PatientServiceImpl;

/**
 * @Author Curstin Rose - 220275408
 * AppointmentPatientAPI.java
 * 2022/10/26
 */
@Component
public class AppointmentPatientAPI {

    private final AppointmentServiceImpl appointmentService;
    private final PatientServiceImpl patientService;

    @Autowired
    public AppointmentPatientAPI(AppointmentServiceImpl appointmentService, PatientServiceImpl patientService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
    }

    public Appointment saveAppointmentWithPatient(Appointment appointment) {
        Patient patient = patientService.findById(appointment.getPatient().getId()).orElseThrow(
                () -> new ResourceNotFoundException(getNotFoundMessage(appointment.getPatient().getId())));
        appointment.setPatient(patient);
        return appointmentService.save(appointment);
    }

    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Patient with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
