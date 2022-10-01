package za.ac.cput.service.payment.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.payment.MedicalAid;
import za.ac.cput.factory.payment.MedicalAidFactory;
import za.ac.cput.repository.payment.MedicalAidRepository;
import za.ac.cput.service.payment.IMedicalAidService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @Author Curstin Rose - 220275408
 * MedicalAidServiceImpl.java
 * 2022/10/01
 */
@Service
public class MedicalAidServiceImplService implements IMedicalAidService {

    private final MedicalAidRepository medicalAidRepository;

    @Autowired
    public MedicalAidServiceImplService(MedicalAidRepository medicalAidRepository) {
        this.medicalAidRepository = medicalAidRepository;
    }

    @Override
    public MedicalAid save(MedicalAid medicalAid) {
        return medicalAidRepository.save(medicalAid);
    }

    @Override
    public Optional<MedicalAid> update(Long id, MedicalAid newMedicalAid) {
        return findById(id).map(medicalAid -> {
            LocalDate claimDate = medicalAid.getClaimDate();
            String claimType = medicalAid.getClaimType();
            String medicalAidName = medicalAid.getMedicalAidName();
            Long medicalAidNo = medicalAid.getMedicalAidNo();
            medicalAid = MedicalAidFactory.createMedicalAid(id, claimDate, claimType, medicalAidName, medicalAidNo);
            return save(medicalAid);
        });
    }

    @Override
    public List<MedicalAid> findAll() {
        return medicalAidRepository.findAll();
    }

    @Override
    public Optional<MedicalAid> findById(Long id) {
        return medicalAidRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        medicalAidRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return medicalAidRepository.existsById(id);
    }
}
