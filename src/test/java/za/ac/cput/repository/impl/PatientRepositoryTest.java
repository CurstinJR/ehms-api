package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Patient;
import za.ac.cput.factory.PatientFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 * PatientRepositoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
@TestMethodOrder(OrderAnnotation.class)
class PatientRepositoryTest
{
    private static final PatientRepository patientRepository = PatientRepository.getPatientRepository();
    private static Patient patient0 = PatientFactory.createPatient("Quinn", "Frost");

    @Test
    @Order(1)
    void getPatientRepository()
    {
        PatientRepository patientRepositoryMock = PatientRepository.getPatientRepository();

        assertEquals(patientRepositoryMock.hashCode(), patientRepository.hashCode());
    }

    @Test
    @Order(2)
    void save()
    {
        Patient savedPatient = patientRepository.save(patient0);
        Long patientId = savedPatient.getPatientId();

        assertEquals(patientId, patient0.getPatientId());
    }

    @Test
    @Order(3)
    void findById()
    {
        Patient patient = patientRepository
                .findById(patient0.getPatientId())
                .orElseThrow();

        assertNotNull(patient);
    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<Patient> patients = patientRepository.findAll();
        assertEquals(1, patients.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long patientId = patient0.getPatientId();
        String patientName = patient0.getPatientName();

        patient0.setPatientName("Quinntessia");
        Patient updatePatient = patientRepository.update(patient0);

        assertEquals(patientId, updatePatient.getPatientId());
        assertNotEquals(patientName, updatePatient.getPatientName());
        assertEquals(patient0, updatePatient);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean patientExists = patientRepository.existsById(patient0.getPatientId());

        assertTrue(patientExists);
    }

    @Test
    @Order(7)
    void delete()
    {
        patientRepository.deleteById(patient0.getPatientId());

        assertTrue(patientRepository.findAll().isEmpty());
    }
}