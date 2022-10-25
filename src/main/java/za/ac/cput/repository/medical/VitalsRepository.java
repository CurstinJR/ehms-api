package za.ac.cput.repository.medical;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.medical.Vitals;

import java.util.Optional;

public interface VitalsRepository extends JpaRepository<Vitals, Long> {
    Optional<Vitals> findVitalsByPatientId(Long id);
}
