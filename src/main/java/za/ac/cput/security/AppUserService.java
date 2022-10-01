package za.ac.cput.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.user.LoginCredentialsRepository;

/**
 * @Author Curstin Rose - 220275408
 * AppUserService.java
 * 2022/10/01
 */
@Service
public class AppUserService implements UserDetailsService {

    private final LoginCredentialsRepository loginCredentialsRepository;

    @Autowired
    public AppUserService(LoginCredentialsRepository loginCredentialsRepository) {
        this.loginCredentialsRepository = loginCredentialsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return loginCredentialsRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User with email %s not found", email)));
    }
}
