package za.ac.cput.security.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.service.user.impl.LoginCredentialsServiceImpl;

import java.util.Objects;

/**
 * @Author Curstin Rose - 220275408
 * UserSecurity.java
 * 2022/10/18
 */
@Component("userSecurity")
@Slf4j
public class UserSecurity {

    private final LoginCredentialsServiceImpl loginCredentialsServiceImpl;

    @Autowired
    public UserSecurity(LoginCredentialsServiceImpl loginCredentialsServiceImpl) {
        this.loginCredentialsServiceImpl = loginCredentialsServiceImpl;
    }

    public boolean hasUserId(Authentication auth, Long id) {
        LoginCredentials currentLoggedInUser = loginCredentialsServiceImpl
                .findByEmail(auth.getName()).orElseThrow();
        if (auth.getAuthorities() != currentLoggedInUser.getEmployee().getRole()) {
            log.info("{}", auth.getCredentials());
            return false;
        }
        log.info("{}", currentLoggedInUser);
        return Objects.equals(currentLoggedInUser.getId(), id);
    }
}
