package za.ac.cput.service.user;

import za.ac.cput.entity.user.Patient;
import za.ac.cput.service.IService;

public interface IPatientService extends IService<Patient, Long> {
    boolean existsById(Long id);
}
