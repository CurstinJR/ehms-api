package za.ac.cput.repository.impl;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Bill;
import za.ac.cput.factory.BillFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

/**
 * BillRepositoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
@TestMethodOrder(OrderAnnotation.class)
class BillRepositoryTest
{
    private static final BillRepository billRepository = BillRepository.getBillRepository();
    private static Bill bill1 = BillFactory.createBill(
            LocalDate.of(2022, 4, 10),
            BigDecimal.valueOf(599.99),
            "Bill for 3 cough syrups");

    @Test
    @Order(1)
    void getBillRepository()
    {
        BillRepository billRepositoryMock = BillRepository.getBillRepository();

        assertEquals(billRepositoryMock.hashCode(), billRepositoryMock.hashCode());
    }

    @Test
    @Order(2)
    void save()
    {
        Bill savedBill = billRepository.save(bill1);
        Long patientId = savedBill.getBillId();

        assertEquals(patientId, bill1.getBillId());
    }

    @Test
    @Order(3)
    void findById()
    {
        Bill bill = billRepository
                .findById(bill1.getBillId())
                .orElseThrow();

        assertNotNull(bill);
    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<Bill> bills = billRepository.findAll();
        assertEquals(1, bills.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long billId = bill1.getBillId();
        BigDecimal billAmount = bill1.getBillAmount();

        bill1.setBillAmount(BigDecimal.valueOf(600.00));
        Bill updateBill = billRepository.update(bill1);

        assertEquals(billId, updateBill.getBillId());
        assertNotEquals(billAmount, updateBill.getBillAmount());
        assertEquals(bill1, updateBill);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean billExists = billRepository.existsById(bill1.getBillId());

        assertTrue(billExists);
    }

    @Test
    @Order(7)
    void deleteById()
    {
        billRepository.deleteById(bill1.getBillId());

        assertTrue(billRepository.findAll().isEmpty());
    }
}