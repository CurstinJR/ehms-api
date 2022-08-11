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
        patientZero = new Patient.Builder()
                .patientId(100L)
                .patientName("Quinn")
                .build();

        patientOne = new Patient.Builder()
                .patientId(101L)
                .patientSurname("Frost")
                .build();
    }

    @Test
    public void patientBuilderTest_shouldEqual() {
        patientOne = new Patient.Builder()
                .copy(patientZero)
                .build();

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
        patientOne = new Patient.Builder()
                .copy(patientZero)
                .build();

        assertNotSame(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotEqualHash() {
        for (long i = 0L; i < 100L; i++) {
            Patient patient1 = new Patient.Builder()
                    .patientId(i)
                    .build();

            Patient patient2 = new Patient.Builder()
                    .patientId(i + 1)
                    .build();

            assertNotEquals(patient1.hashCode(), patient2.hashCode());
        }
    }

    @Test
    public void patientBuilderTest_shouldEqualHash() {
        patientOne = new Patient.Builder()
                .copy(patientZero)
                .build();

        assertEquals(patientZero, patientOne);
    }
}