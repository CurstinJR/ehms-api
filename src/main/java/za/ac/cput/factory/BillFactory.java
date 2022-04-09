package za.ac.cput.factory;

import za.ac.cput.entity.Bill;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillFactory
{
    public static Bill createBill(long billId, LocalDate billDate,
                                        BigDecimal billAmount, String billDescription)
    {
        return new Bill.Builder()
                .billId(billId)
                .billDate(billDate)
                .billAmount(billAmount)
                .billDescription(billDescription)
                .build();
    }
}
