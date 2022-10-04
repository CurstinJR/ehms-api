package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.Patient;

/**
 * @Author Curstin Rose - 220275408
 * PatientRepository.java
 * 2022/10/01
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
