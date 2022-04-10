package za.ac.cput.repository.impl;

import za.ac.cput.entity.LoginCredentials;


import java.util.*;


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
 public static LoginCredentialsRepository getLoginCredentialsRepository() {
   if(loginCredentialsRepository == null) {
       loginCredentialsRepository = new LoginCredentialsRepository();
   }
   return loginCredentialsRepository;
}
@Override
public LoginCredentials save(LoginCredentials loginCredentials) {
   boolean success = loginCredentialsDB.add(loginCredentials);
   if(!success)
       return null;
       return loginCredentials;
}

    @Override
    public Optional<LoginCredentials> findById(Long id) {
    LoginCredentials loginCredentials = loginCredentialsDB.stream().
            filter(f -> f.getId() == id)
            .findFirst()
            .orElse(null);
    return Optional.ofNullable(loginCredentials);
    }

    public Collection<LoginCredentials> findAll() {

    return loginCredentialsDB;

    }

    @Override
    public LoginCredentials update(LoginCredentials loginCredentials) {
      long id = loginCredentials.getId();
      LoginCredentials oldLoginCredentials = findById(id).orElseThrow();

      loginCredentialsDB.remove(oldLoginCredentials);
      loginCredentialsDB.add(loginCredentials);
      return loginCredentials;
    }

    @Override
    public boolean deleteById(Long id ) {
       LoginCredentials loginCredentials = loginCredentialsRepository.findById(id).orElseThrow();

        return loginCredentialsDB.remove(loginCredentials);
    }



    @Override
    public boolean existsById(Long id) {
        return loginCredentialsDB.stream()
                .anyMatch(loginCredentials -> loginCredentials.getId() == id);
    }

    @Override
    public Set<LoginCredentials> getAll() {
        return null;
    }
}
