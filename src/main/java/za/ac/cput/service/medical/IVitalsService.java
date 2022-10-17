package za.ac.cput.service.medical;

import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.service.IService;
/*
IVitalsService.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

public interface IVitalsService extends IService<Vitals, Long> {
    boolean existsById(Long id);
}
