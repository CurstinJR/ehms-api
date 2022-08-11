package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.payment.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BillTest.java
 * Author: Curstin Rose - 220275408
 * Date: 6 April 2022
 */
class BillTest {
    Bill bill1;
    Bill bill2;

    @BeforeEach
    void setUp() {
        bill1 = new Bill.Builder()
                .billId(1L)
                .billAmount(BigDecimal.valueOf(299.99))
                .billDescription("Bill for patient zero: Bought 1 cough syrup")
                .billDate(LocalDate.of(2022, 5, 15))
                .build();

        bill2 = new Bill.Builder()
                .billId(2L)
                .billAmount(BigDecimal.valueOf(199.99))
                .billDescription("Bill for patient one: Bought 2 cough syrups")
                .billDate(LocalDate.of(2022, 3, 10))
                .build();
    }

    @Test
    public void billBuilderTest_shouldEqual() {
        bill2 = new Bill.Builder()
                .copy(bill1)
                .build();

        assertEquals(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldNotEqual() {
        assertNotEquals(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldBeSame() {
        bill2 = bill1;
        assertSame(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldNotBeSame() {
        bill2 = new Bill.Builder()
                .copy(bill1)
                .build();

        assertNotSame(bill1, bill2);
    }

    @Test
    public void patientBuilderTest_shouldNotEqualHash() {
        for (long i = 0L; i < 100L; i++) {
            Bill bill1 = new Bill.Builder()
                    .billId(i)
                    .build();

            Bill bill2 = new Bill.Builder()
                    .billId(i + 1)
                    .build();

            assertNotEquals(bill1.hashCode(), bill2.hashCode());
        }
    }

    @Test
    public void patientBuilderTest_shouldEqualHash() {
        bill2 = new Bill.Builder()
                .copy(bill1)
                .build();

        assertEquals(bill1, bill2);
    }
}
