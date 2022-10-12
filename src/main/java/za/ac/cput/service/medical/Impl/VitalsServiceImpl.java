package za.ac.cput.service.medical.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.factory.medical.VitalsFactory;
import za.ac.cput.repository.medical.VitalsRepository;
import za.ac.cput.service.medical.IVitalsService;

import java.util.List;
import java.util.Optional;

/*
VitalsServiceImpl.java
Author: Tarren-Marc Adams - 214041794
Date: 2/10/2022
 */

@Service
public class VitalsServiceImpl implements IVitalsService {

    private final VitalsRepository vitalsRepository;

    @Autowired
    public VitalsServiceImpl(VitalsRepository vitalsRepository){this.vitalsRepository = vitalsRepository;}

    @Override
    public Vitals save(Vitals vitals){return vitalsRepository.save(vitals);}

    @Override
    public Optional<Vitals> update(Long id, Vitals newVitals) {
        return findById(id).map(vitals -> {
            Double weight = newVitals.getWeight();
            Double height = newVitals.getHeight();
            String bloodPressure = newVitals.getBloodPressure();
            Double temperature = newVitals.getTemperature();
            vitals = VitalsFactory.createVitals(id, weight, height, bloodPressure, temperature);
            return save(vitals);
        });
    }

    @Override
    public List<Vitals> findAll() {
        return vitalsRepository.findAll();
    }

    @Override
    public Optional<Vitals> findById(Long id) {
        return vitalsRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        vitalsRepository.deleteById(id);

    }


    @Override
    public boolean existsById(Long id) {
        return vitalsRepository.existsById(id);
    }
}
