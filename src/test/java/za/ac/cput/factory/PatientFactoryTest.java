package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Patient;
import za.ac.cput.factory.user.PatientFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * PatientFactoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
class PatientFactoryTest {
    @Test
    void createPatientFactoryTest() {
        Patient patient = PatientFactory.createPatient("Patient", "Zero");

        assertNotNull(patient);
    }
}