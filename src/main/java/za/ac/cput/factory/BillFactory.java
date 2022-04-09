package za.ac.cput.factory;

import za.ac.cput.entity.Bill;
import za.ac.cput.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BillFactory
{
    public static Bill createBill(LocalDate billDate,
                                        BigDecimal billAmount, String billDescription)
    {
        Long billId = Helper.generateId();

        return new Bill.Builder()
                .billId(billId)
                .billDate(billDate)
                .billAmount(billAmount)
                .billDescription(billDescription)
                .build();
    }
}
