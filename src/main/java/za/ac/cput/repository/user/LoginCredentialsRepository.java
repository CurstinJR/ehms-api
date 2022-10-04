package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.LoginCredentials;

import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * LoginCredentialsRepository.java
 * 2022/10/01
 */
@Repository
public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Long> {
    Optional<LoginCredentials> findByEmail(String email);
}
