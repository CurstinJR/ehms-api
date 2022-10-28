package za.ac.cput.service.payment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.payment.Bill;
import za.ac.cput.factory.payment.BillFactory;
import za.ac.cput.repository.payment.BillRepository;
import za.ac.cput.service.payment.IBillService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * BillServiceImpl.java
 * 2022/10/01
 */
@Service
public class BillServiceImpl implements IBillService {

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Optional<Bill> update(Long id, Bill newBill) {
        return findById(id).map(bill -> {
            BigDecimal billAmount = newBill.getAmount();
            LocalDate billDate = newBill.getDate();
            bill = BillFactory.createBill(id, billAmount, billDate);
            return save(bill);
        });
    }

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return billRepository.existsById(id);
    }
}
