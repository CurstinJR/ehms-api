package za.ac.cput.repository.impl;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Vitals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class VitalsRepository implements IVitals{

    private static VitalsRepository vitalsRepository = null;

    private Collection<Vitals> vitalsDB = null;

    private VitalsRepository()
    {
        vitalsDB = new ArrayList<>();
    }

    public static VitalsRepository getVitalsRepository()
    {
        return vitalsRepository == null ?
                vitalsRepository = new VitalsRepository() :
                vitalsRepository;
    }

    @Override
    public Vitals save(Vitals vitals)
    {
        vitalsDB.add(vitals);
        return vitals;
    }

    @Override
    public Optional<Vitals> findById(Long vitalsId)
    {
        Vitals vitals = vitalsDB.stream()
                .filter(v -> v.getVitalsId().equals(vitalsId))
                .findFirst()
                .orElse(null);

        return Optional.ofNullable(vitals);
    }

    @Override
    public Collection<Vitals> findAll()

    {
        return vitalsDB;
    }

    @Override
    public Vitals update(Vitals vitals)
    {
        Long vitalsId = vitals.getVitalsId();
        Vitals oldVitals = findById(vitalsId).orElseThrow();
        vitalsDB.remove(oldVitals);
        vitalsDB.add(vitals);

        return vitals;
    }

    @Override
    public boolean deleteById(Long vitalsId)
    {
        Vitals vitals = vitalsRepository.findById(vitalsId).orElseThrow();
        vitalsDB.remove(vitals);
        return true;
    }

    @Override
    public boolean existsById(Long vitalsId)
    {
        vitalsDB.stream().
                anyMatch(vitals -> vitals.getVitalsId().equals(vitalsId));
        return true;
    }


}
