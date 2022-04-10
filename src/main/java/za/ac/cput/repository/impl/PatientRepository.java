package za.ac.cput.repository.impl;

import za.ac.cput.entity.Patient;

import java.util.*;

/**
 * PatientRepository.java
 * Author: Curstin Rose - 220275408
 * Date: 5 April 2022
 */
public class PatientRepository implements IPatientRepository
{
    private static PatientRepository patientRepository = null;

    private Collection<Patient> patientDB = null;

    private PatientRepository()
    {
        patientDB = new ArrayList<>();
    }

    public static final PatientRepository getPatientRepository()
    {
        return patientRepository == null ?
                patientRepository = new PatientRepository() :
                patientRepository;
    }

    @Override
    public Patient save(Patient patient)
    {
        patientDB.add(patient);
        return patient;
    }

    @Override
    public Optional<Patient> findById(Long patientId)
    {
        Patient patient = patientDB.stream()
                .filter(p -> p.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(patient);
    }

    public Collection<Patient> findAll()
    {
        return patientDB;
    }

    @Override
    public Patient update(Patient patient)
    {
        Long patientId = patient.getPatientId();
        Patient oldPatient = findById(patientId).orElseThrow();
        patientDB.remove(oldPatient);
        patientDB.add(patient);

        return patient;
    }

    @Override
    public boolean deleteById(Long patientId)
    {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        return patientDB.remove(patient);
    }

    @Override
    public boolean existsById(Long patientId)
    {
        return patientDB.stream()
                .anyMatch(patient -> patient.getPatientId().equals(patientId));
    }
}
