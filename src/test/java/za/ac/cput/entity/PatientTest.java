package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest
{
    Patient patientZero;
    Patient patientOne;

    @BeforeEach
    void setUp()
    {
        patientZero = new Patient.Builder()
                .patientId(100L)
                .patientFirstName("Quinn")
                .build();

        patientOne = new Patient.Builder()
                .patientId(101L)
                .patientLastname("Frost")
                .build();
    }

    @Test
    public void patientBuilderTest_shouldEqual()
    {
        Patient patientOne = new Patient.Builder()
                .copy(patientZero);

        assertEquals(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotEqual()
    {
       assertNotEquals(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldBeSame()
    {
        Patient patientOne = new Patient.Builder()
                .copy(patientZero);

        assertSame(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotBeSame()
    {
        assertNotSame(patientZero, patientOne);
    }

    @Test
    public void patientBuilderTest_shouldNotEqualHash()
    {
        for (long i = 0L; i < 100L; i++)
        {
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
    public void patientBuilderTest_shouldEqualHash()
    {
        Patient patientOne = new Patient.Builder()
                .copy(patientZero);

        assertEquals(patientZero, patientOne);
    }
}