package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * BillFactoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
class BillFactoryTest
{
    @Test
    void createBillTest()
    {
        Bill bill = BillFactory.createBill(LocalDate.of(2022, 6, 17),
                BigDecimal.valueOf(1689.99), "Bill for 3 cough syrups");

        assertNotNull(bill);
    }
}