package za.ac.cput.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.payment.MedicalAid;

@Repository
public interface MedicalAidRepository extends JpaRepository<MedicalAid, Long> {
}
