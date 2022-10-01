package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.payment.MedicalAid;
import za.ac.cput.factory.payment.MedicalAidFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * MedicalAidFactoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
class MedicalAidRepositoryFactoryTest {
    @Test
    void createMedicalAidTest() {
        MedicalAid medicalAid = MedicalAidFactory.createMedicalAid(1L,
                LocalDate.of(2022, 5, 16),
                "ClaimType1",
                "Bonitas",
                1234_4567_8901_2345L);

        assertNotNull(medicalAid);
    }
}