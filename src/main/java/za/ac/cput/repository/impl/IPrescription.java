package za.ac.cput.repository.impl;


import za.ac.cput.entity.Prescription;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IPrescription extends IRepository<Prescription, Long> {


    void delete(Prescription prescription);
    public Set<Prescription> getAll();
}