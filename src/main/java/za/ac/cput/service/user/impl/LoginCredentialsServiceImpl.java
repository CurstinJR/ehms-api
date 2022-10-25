package za.ac.cput.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.LoginCredentials;
import za.ac.cput.repository.user.LoginCredentialsRepository;
import za.ac.cput.service.user.ILoginCredentialsService;

import java.util.List;
import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * LoginCredentialsService.java
 * 2022/10/19
 */
@Service
public class LoginCredentialsServiceImpl implements ILoginCredentialsService {

    private final LoginCredentialsRepository loginCredentialsRepository;

    @Autowired
    public LoginCredentialsServiceImpl(LoginCredentialsRepository loginCredentialsRepository) {
        this.loginCredentialsRepository = loginCredentialsRepository;
    }

    @Override
    public LoginCredentials save(LoginCredentials loginCredentials) {
        return null;
    }

    @Override
    public Optional<LoginCredentials> update(Long aLong, LoginCredentials loginCredentials) {
        return Optional.empty();
    }

    @Override
    public List<LoginCredentials> findAll() {
        return null;
    }

    @Override
    public Optional<LoginCredentials> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public Optional<LoginCredentials> findByEmail(String email) {
        return loginCredentialsRepository.findByEmail(email);
    }
}
