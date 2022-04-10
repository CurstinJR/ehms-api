package za.ac.cput.repository.impl;

import za.ac.cput.entity.LoginCredentials;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/*
ILoginCredentialsRepository.java
Author:Kevin Lionel Mombo Ndinga(218180500)
Date: 10 April 2022
*/
public interface ILoginCredentialsRepository extends IRepository<LoginCredentials, Long> {

    public Set<LoginCredentials> getAll();
}
