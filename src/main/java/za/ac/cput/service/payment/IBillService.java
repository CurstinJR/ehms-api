package za.ac.cput.service.payment;

import za.ac.cput.entity.payment.Bill;
import za.ac.cput.service.IService;

/**
 * @Author Curstin Rose - 220275408
 * IBillService.java
 * 2022/10/01
 */
public interface IBillService extends IService<Bill, Long> {
    boolean existsById(Long id);
}
