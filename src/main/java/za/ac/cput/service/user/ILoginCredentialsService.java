package za.ac.cput.service.user;

import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.service.IService;

import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * ILoginCredentials.java
 * 2022/10/19
 */
public interface ILoginCredentialsService extends IService<LoginCredentials, Long> {
    Optional<LoginCredentials> findByEmail(String email);
}
