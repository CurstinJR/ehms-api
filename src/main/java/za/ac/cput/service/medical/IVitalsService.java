package za.ac.cput.service.medical;

import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.service.IService;

public interface IVitalsService extends IService<Vitals, Long> {
    boolean existsById(Long id);
}
