package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.Patient;
import za.ac.cput.exception.ResourceNotFoundException;
import za.ac.cput.service.user.impl.PatientServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientServiceImpl patientService;

    @Autowired
    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    /**
     * Handles the request to retrieve all patients and return an array of
     * patient objects.
     *
     * @return List of Patient objects
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getPatients() {
        List<Patient> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    /**
     * Handles the request to retrieve a specific Patient object by providing
     * an ID. Throws 404 NOT_FOUND, if Patient object is not in the repository.
     *
     * @param id Long
     * @return 200 and Patient object SUCCESS
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable final Long id) {
        String notFoundMessage = getNotFoundMessage(id);
        Patient patient = patientService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(patient);
    }

    /**
     * Handles the request to create a new Patient object.
     *
     * @param patient Patient JSON payload
     * @return 201 and new Patient object
     */
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody final Patient patient) {
        Patient savePatient = patientService.save(patient);
        return new ResponseEntity<>(savePatient, HttpStatus.CREATED);
    }

    /**
     * Handles the request to update a new Patient object.
     *
     * @param id      Long
     * @param patient Patient JSON payload
     * @return 200 and updated Patient object
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable final Long id,
                                                     @RequestBody final Patient patient) {
        String notFoundMessage = getNotFoundMessage(id);
        Patient updatePatient = patientService.update(id, patient)
                .orElseThrow(() -> new ResourceNotFoundException(notFoundMessage));
        return ResponseEntity.ok(updatePatient);
    }

    /**
     * Handles the request to delete a Patient object from the repository.
     * Throws 404 NOT_FOUND, if Patient object is not in the repository.
     *
     * @param id Long
     * @return 204 No content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable final Long id) {
        if (!patientService.existsById(id)) {
            String notFoundMessage = getNotFoundMessage(id);
            throw new ResourceNotFoundException(notFoundMessage);
        }
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * @param id Long
     * @return Resource not found error message
     */
    private String getNotFoundMessage(final Long id) {
        final String messageNotFound = "Patient with id: %s not found";
        return String.format(messageNotFound, id);
    }
}
