package za.ac.cput.repository.impl;
/*
LabTestRepository.java
Author:Kevin Lionel Mombo Ndinga
Date: 10 April 2022
 */

import za.ac.cput.entity.LabTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class LabTestRepository implements ILabTestRepository
{
    private static LabTestRepository labTestRepository = null;

    private Collection<LabTest> labTestsDB = null;

    private LabTestRepository() {
        labTestsDB = new ArrayList<>();
    }

    public static LabTestRepository getLabTestRepository () {
        if(labTestRepository == null) {
            labTestRepository =new LabTestRepository();
        }
        return labTestRepository;
    }

    @Override
    public LabTest save(LabTest labTest) {
        boolean success = labTestsDB.add(labTest);
        if(!success)
            return null;
        return labTest;
    }

    @Override
    public Optional<LabTest> findById(Long testId) {
        LabTest labTest = labTestsDB.stream().
                filter(f -> f.getTestId() == testId)
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(labTest);
    }

    @Override
    public Collection <LabTest> findAll() {

        return labTestsDB;
    }

    @Override
    public LabTest update(LabTest labTest) {
        long testID = labTest.getTestId();
        LabTest oldLabTest = findById(testID).orElseThrow();

        labTestsDB.remove(oldLabTest);
        labTestsDB.add(labTest);
        return labTest;
    }

    @Override
    public boolean deleteById(Long testId ) {
        LabTest labTest = labTestRepository.findById(testId).orElseThrow();

        return labTestsDB.remove(labTest);
    }

    @Override
    public boolean existsById(Long TestId) {
        return labTestsDB.stream()
                .anyMatch(labTest -> labTest.getTestId() == TestId);
    }

    @Override
    public Set<LabTest> getAll() {
        return null;
    }
}
