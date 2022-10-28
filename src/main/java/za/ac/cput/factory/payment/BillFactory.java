package za.ac.cput.factory.payment;

import za.ac.cput.entity.payment.Bill;
import za.ac.cput.entity.user.Patient;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * BillFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class BillFactory {
    public static Bill createBill(Long billId, BigDecimal billAmount, LocalDate billDate) {
        return Bill.builder()
                .id(billId)
                .amount(billAmount)
                .date(billDate)
                .build();
    }

    public static Bill createBillWithPatient(Long billId, BigDecimal billAmount, LocalDate billDate, Patient patient) {
        return Bill.builder()
                .id(billId)
                .amount(billAmount)
                .date(billDate)
                .patient(patient)
                .build();
    }
}
