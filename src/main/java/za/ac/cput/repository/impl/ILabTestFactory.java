package za.ac.cput.repository.impl;

import za.ac.cput.entity.LabTest;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ILabTestFactory extends IRepository<LabTestRepository,Long> {

    public Set<LabTest> getAll();
}
