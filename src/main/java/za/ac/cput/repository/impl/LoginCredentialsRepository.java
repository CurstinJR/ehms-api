package za.ac.cput.repository.impl;

import za.ac.cput.entity.LoginCredentials;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


/*
LoginCredentialsRepository.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 10 April 2022
*/
public class LoginCredentialsRepository implements ILoginCredentialsRepository {

private static LoginCredentialsRepository loginCredentialsRepository = null;

private Collection<LoginCredentials> loginCredentialsDB = null;

private LoginCredentialsRepository() {
    loginCredentialsDB = new ArrayList<>();

}
 public static final LoginCredentialsRepository getLoginCredentialsRepository() {
    return loginCredentialsRepository == null ?
            loginCredentialsRepository = new LoginCredentialsRepository():
            loginCredentialsRepository;
}

    @Override
    public LoginCredentialsRepository save(LoginCredentialsRepository entity) {
        return null;
    }

    @Override
    public Optional<LoginCredentialsRepository> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<LoginCredentialsRepository> findAll() {
        return null;
    }

    @Override
    public LoginCredentialsRepository update(LoginCredentialsRepository entity, Long aLong) {
        return null;
    }

    @Override
    public void delete(LoginCredentialsRepository entity) {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }
}
