package za.ac.cput.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.repository.user.EmployeeRepository;
import za.ac.cput.repository.user.LoginCredentialsRepository;

/**
 * @Author Curstin Rose - 220275408
 * AppUserService.java
 * 2022/10/01
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginCredentialsRepository loginCredentialsRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public CustomUserDetailsService(LoginCredentialsRepository loginCredentialsRepository,
                                    EmployeeRepository employeeRepository) {
        this.loginCredentialsRepository = loginCredentialsRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        LoginCredentials loginCredentials = loginCredentialsRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("User with email %s not found", email)));
        Employee employee = employeeRepository.findById(loginCredentials.getEmployee().getId()).orElseThrow();
        return CustomUserDetails.builder()
                .id(employee.getId())
                .email(loginCredentials.getEmail())
                .password(loginCredentials.getPassword())
                .role(employee.getRole())
                .build();
    }
}
