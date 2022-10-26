package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.medical.Vitals;
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
        Vitals vitals = new Vitals();
        Patient patient = PatientFactory.createPatient(1L, "Patient", "Zero", vitals);
        assertNotNull(patient);
    }
}