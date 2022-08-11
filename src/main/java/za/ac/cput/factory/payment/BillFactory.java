package za.ac.cput.factory.payment;

import za.ac.cput.entity.payment.Bill;
import za.ac.cput.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * BillFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class BillFactory {
    public static Bill createBill(LocalDate billDate, BigDecimal billAmount, String billDescription) {
        Long billId = Helper.generateId();

        return new Bill.Builder()
                .billId(billId)
                .billDate(billDate)
                .billAmount(billAmount)
                .billDescription(billDescription)
                .build();
    }
}
