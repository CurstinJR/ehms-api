package za.ac.cput.repository.impl;

import za.ac.cput.entity.Patient;
import za.ac.cput.repository.IRepository;

import java.util.Collection;
import java.util.Optional;

/*
IRepository.java
Author: Curstin Rose - 220275408
Date: 5 April 2022
 */
public class PatientRepository implements IRepository<Patient, Long>
{
    @Override
    public Patient save(Patient entity)
    {
        return null;
    }

    @Override
    public Optional<Patient> findById(Long id)
    {
        return Optional.empty();
    }

    @Override
    public Collection<Patient> findAll()
    {
        return null;
    }

    @Override
    public Patient update(Patient entity)
    {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }



    @Override
    public boolean existsById(Long id)
    {
        return false;
    }
}
