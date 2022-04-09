package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Patient;

import static org.junit.jupiter.api.Assertions.*;

class PatientFactoryTest
{
    @Test
    void createPatientFactoryTest()
    {
        Patient patient = PatientFactory.createPatient(1L, "Patient", "Zero");

        assertNotNull(patient);
    }
}