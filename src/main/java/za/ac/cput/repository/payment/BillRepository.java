package za.ac.cput.repository.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.payment.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
