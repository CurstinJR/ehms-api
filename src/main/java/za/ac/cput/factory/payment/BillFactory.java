package za.ac.cput.factory.payment;

import za.ac.cput.entity.payment.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * BillFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class BillFactory {
    public static Bill createBill(Long billId, BigDecimal billAmount, String billDescription, LocalDate billDate) {
        return new Bill.Builder()
                .billId(billId)
                .billAmount(billAmount)
                .billDescription(billDescription)
                .billDate(billDate)
                .build();
    }
}
