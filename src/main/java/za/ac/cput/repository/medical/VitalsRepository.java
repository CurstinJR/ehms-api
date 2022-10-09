package za.ac.cput.repository.medical;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.medical.Vitals;

public interface VitalsRepository extends JpaRepository<Vitals, Long> {

}
