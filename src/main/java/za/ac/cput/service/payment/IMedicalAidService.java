package za.ac.cput.service.payment;

import za.ac.cput.entity.payment.MedicalAid;
import za.ac.cput.service.IService;

/**
 * @Author Curstin Rose - 220275408
 * IMedicalAid.java
 * 2022/10/01
 */
public interface IMedicalAidService extends IService<MedicalAid, Long> {
    boolean existsById(Long id);
}
