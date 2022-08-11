package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.payment.MedicalAid;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MedicalAidTest.java
 * Author: Curstin Rose - 220275408
 * Date: 6 April 2022
 */
class MedicalAidTest {
    MedicalAid medicalAid1;
    MedicalAid medicalAid2;

    @BeforeEach
    void setUp() {
        medicalAid1 = new MedicalAid.Builder()
                .claimId(1L)
                .claimDate(LocalDate.of(2023, 6, 19))
                .medicalAidName("Medical Insurance A")
                .medicalAidNo(4567_1234_9879_4849L)
                .build();

        medicalAid2 = new MedicalAid.Builder()
                .claimId(2L)
                .claimDate(LocalDate.of(2022, 8, 29))
                .medicalAidName("Medical Insurance B")
                .medicalAidNo(1234_6549_4568_1245L)
                .build();
    }

    @Test
    public void medicalAidBuilderTest_shouldEqual() {
        medicalAid2 = new MedicalAid.Builder()
                .copy(medicalAid1)
                .build();

        assertEquals(medicalAid1, medicalAid2);
    }

    @Test
    public void medicalAidBuilderTest_shouldNotEqual() {
        assertNotEquals(medicalAid1, medicalAid2);
    }

    @Test
    public void medicalAidBuilderTest_shouldBeSame() {
        medicalAid2 = medicalAid1;

        assertSame(medicalAid1, medicalAid2);
    }

    @Test
    public void medicalAidBuilderTest_shouldNotBeSame() {
        assertNotSame(medicalAid1, medicalAid2);
    }

    @Test
    public void medicalAidBuilderTest_shouldNotEqualHash() {
        for (long i = 0L; i < 100L; i++) {
            MedicalAid medicalAid1 = new MedicalAid.Builder()
                    .claimId(i)
                    .medicalAidNo(i + 1)
                    .build();

            MedicalAid medicalAid2 = new MedicalAid.Builder()
                    .claimId(i + 1)
                    .medicalAidNo(i + 1)
                    .build();

            assertNotEquals(medicalAid1.hashCode(), medicalAid2.hashCode());
        }
    }

    @Test
    public void medicalAidBuilderTest_shouldEqualHash() {
        medicalAid2 = new MedicalAid.Builder()
                .copy(medicalAid1)
                .build();

        assertEquals(medicalAid1, medicalAid2);
    }
}