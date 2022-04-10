package za.ac.cput.repository.impl;

import za.ac.cput.entity.LabTest;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface ILabTestRepository extends IRepository<LabTest,Long> {


    public Set<LabTest> getAll();
}
