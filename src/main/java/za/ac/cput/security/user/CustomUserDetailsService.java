package za.ac.cput.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.entity.user.Staff;
import za.ac.cput.repository.StaffRepository;
import za.ac.cput.repository.user.LoginCredentialsRepository;

/**
 * @Author Curstin Rose - 220275408
 * AppUserService.java
 * 2022/10/01
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginCredentialsRepository loginCredentialsRepository;
    private final StaffRepository staffRepository;

    @Autowired
    public CustomUserDetailsService(LoginCredentialsRepository loginCredentialsRepository,
                                    StaffRepository staffRepository) {
        this.loginCredentialsRepository = loginCredentialsRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginCredentials loginCredentials = loginCredentialsRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User with email %s not found", email)));
        Staff staff = staffRepository.findById(loginCredentials.getStaff().getId()).orElseThrow();
        return CustomUserDetails.builder()
                .id(staff.getId())
                .email(loginCredentials.getEmail())
                .password(loginCredentials.getPassword())
                .role(staff.getRole())
                .build();
    }
}
