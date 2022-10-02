package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.Staff;

/**
 * @Author Curstin Rose - 220275408
 * StaffRepository.java
 * 2022/10/02
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
