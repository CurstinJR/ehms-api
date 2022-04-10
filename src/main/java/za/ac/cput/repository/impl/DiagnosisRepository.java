package za.ac.cput.repository.impl;


import za.ac.cput.entity.Diagnosis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/*
DiagnosisRepository.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */
public class DiagnosisRepository implements IDiagnosisRepository

{
    private static DiagnosisRepository diagnosisRepository = null;

    private Collection<Diagnosis> diagnosisDB = null;

    private DiagnosisRepository()
    {
        diagnosisDB = new ArrayList<>();
    }

    public static final DiagnosisRepository getDiagnosisRepository()
    {
        return  diagnosisRepository == null ?
                diagnosisRepository = new DiagnosisRepository() :
                diagnosisRepository;
    }

    @Override
    public Diagnosis save(Diagnosis diagnosis)
    {
        diagnosisDB.add(diagnosis);
        return diagnosis;
    }



    @Override
    public Optional<Diagnosis> findById(Long diagnosisId)
    {
        Diagnosis diagnosis = diagnosisDB.stream()
                .filter(p -> p.getDiagnosisId().equals(diagnosisId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(diagnosis);
    }

    @Override
    public Collection<Diagnosis> findAll()
    {
        return diagnosisDB;
    }



    @Override
    public Diagnosis update(Diagnosis diagnosis)
    {
        Long diagnosisId = diagnosis.getDiagnosisId();
        Diagnosis oldDiagnosis = findById(diagnosisId).orElseThrow();
        diagnosisDB.remove(oldDiagnosis);
        diagnosisDB.add(diagnosis);

        return diagnosis;
    }

    @Override
    public boolean deleteById(Long diagnosisId)
    {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId).orElseThrow();
        return diagnosisDB.remove(diagnosis);
    }

    @Override
    public boolean existsById(Long diagnosisId)
    {
        return diagnosisDB.stream()
                .anyMatch(diagnosis -> diagnosis.getDiagnosisId().equals(diagnosisId));
    }
}

