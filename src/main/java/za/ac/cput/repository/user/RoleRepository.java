package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.Role;

/**
 * @Author Curstin Rose - 220275408
 * RoleRepository.java
 * 2022/10/28
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
