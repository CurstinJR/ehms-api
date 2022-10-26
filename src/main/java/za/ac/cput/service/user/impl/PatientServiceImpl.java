package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.entity.user.Patient;
import za.ac.cput.factory.user.PatientFactory;
import za.ac.cput.repository.user.PatientRepository;
import za.ac.cput.service.user.IPatientService;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> update(Long id, Patient newPatient) {
        return findById(id).map(patient -> {
            String name = newPatient.getFirstName();
            String surname = newPatient.getLastName();
            Vitals vitals = newPatient.getVitals();
            patient = PatientFactory.createPatient(id, name, surname, vitals);
            return save(patient);
        });
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return patientRepository.existsById(id);
    }
}
