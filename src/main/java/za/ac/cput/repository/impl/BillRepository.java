package za.ac.cput.repository.impl;

import za.ac.cput.entity.Bill;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * BillRepository.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
public class BillRepository implements IBillRepository
{
    private static BillRepository billRepository = null;

    private Collection<Bill> billDB = null;

    private BillRepository()
    {
        billDB = new ArrayList<>();
    }

    public static final BillRepository getBillRepository()
    {
        return billRepository == null ?
                billRepository = new BillRepository() :
                billRepository;
    }

    @Override
    public Bill save(Bill bill)
    {
        billDB.add(bill);
        return bill;
    }

    @Override
    public Optional<Bill> findById(Long billId)
    {
        Bill bill = billDB.stream()
                .filter(p -> p.getBillId().equals(billId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(bill);
    }

    @Override
    public Collection<Bill> findAll()
    {
        return billDB;
    }

    @Override
    public Bill update(Bill bill)
    {
        Long billId = bill.getBillId();
        Bill oldBill = findById(billId).orElseThrow();
        billDB.remove(oldBill);

        billDB.add(bill);

        return bill;
    }

    @Override
    public boolean deleteById(Long billId)
    {
        Bill bill = billRepository.findById(billId).orElseThrow();
        return billDB.remove(bill);
    }

    @Override
    public boolean existsById(Long billId)
    {
        return billDB.stream()
                .anyMatch(bill -> bill.getBillId().equals(billId));
    }
}
