package za.ac.cput.repository.impl;

import za.ac.cput.entity.MedicalAid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * MedicalAidRepository.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
public class MedicalAidRepository implements IMedicalAidRepository
{
    private static MedicalAidRepository medicalAidRepository = null;

    private Collection<MedicalAid> medicalAidDB = null;

    private MedicalAidRepository()
    {
        medicalAidDB = new ArrayList<>();
    }

    public static final MedicalAidRepository getMedicalAidRepository()
    {
        return medicalAidRepository == null ?
                medicalAidRepository = new MedicalAidRepository() :
                medicalAidRepository;
    }

    @Override
    public MedicalAid save(MedicalAid medicalAid)
    {
        medicalAidDB.add(medicalAid);
        return medicalAid;
    }

    @Override
    public Optional<MedicalAid> findById(Long medicalAidNo)
    {
        MedicalAid medicalAid = medicalAidDB.stream()
                .filter(m -> m.getMedicalAidNo().equals(medicalAidNo))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(medicalAid);
    }

    @Override
    public Collection<MedicalAid> findAll()
    {
        return medicalAidDB;
    }

    @Override
    public MedicalAid update(MedicalAid medicalAid)
    {
        Long medicalAidNo = medicalAid.getMedicalAidNo();
        MedicalAid oldMedicalAid = findById(medicalAidNo).orElseThrow();
        medicalAidDB.remove(oldMedicalAid);
        medicalAidDB.add(medicalAid);

        return medicalAid;
    }

    @Override
    public boolean deleteById(Long medicalAidNo)
    {
        MedicalAid medicalAid = medicalAidRepository.findById(medicalAidNo).orElseThrow();
        return medicalAidDB.remove(medicalAid);
    }

    @Override
    public boolean existsById(Long medicalAidNo)
    {
        return medicalAidDB.stream()
                .anyMatch(m -> m.getMedicalAidNo().equals(medicalAidNo));
    }
}
