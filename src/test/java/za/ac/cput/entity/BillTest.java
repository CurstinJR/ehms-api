package za.ac.cput.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.payment.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
        bill1 = Bill.builder()
                .id(1L)
                .amount(BigDecimal.valueOf(299.99))
                .date(LocalDate.of(2022, 5, 15))
                .build();

        bill2 = Bill.builder()
                .id(2L)
                .amount(BigDecimal.valueOf(199.99))
                .date(LocalDate.of(2022, 3, 10))
                .build();
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
    public void patientBuilderTest_shouldNotEqualHash() {
        for (long i = 0L; i < 100L; i++) {
            Bill bill1 = Bill.builder()
                    .id(i)
                    .build();

            Bill bill2 = Bill.builder()
                    .id(i + 1)
                    .build();

            assertNotEquals(bill1.hashCode(), bill2.hashCode());
        }
    }
}
