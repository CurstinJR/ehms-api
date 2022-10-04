package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Patient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PatientTest.java
 * Author: Curstin Rose - 220275408
 * Date: 6 April 2022
 */
class PatientTest {
    Patient patientZero;
    Patient patientOne;

    @BeforeEach
    void setUp() {
        patientZero = Patient.builder()
                .id(100L)
                .firstName("Quinn")
                .build();

        patientOne = Patient.builder()
                .id(101L)
                .lastName("Frost")
                .build();
    }

    @Test
    public void patientBuilderTest_shouldEqual() {
        patientOne = patientZero;
        assertEquals(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotEqual() {
        assertNotEquals(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldBeSame() {
        patientOne = patientZero;

        assertSame(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotBeSame() {
        assertNotSame(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotEqualHash() {
        for (long i = 0L; i < 100L; i++) {
            Patient patient1 = Patient.builder()
                    .id(i)
                    .build();

            Patient patient2 = Patient.builder()
                    .id(i + 1)
                    .build();

            assertNotEquals(patient1.hashCode(), patient2.hashCode());
        }
    }

    @Test
    public void patientBuilderTest_shouldEqualHash() {
        patientOne = patientZero;
        assertEquals(patientZero, patientOne);
    }
}