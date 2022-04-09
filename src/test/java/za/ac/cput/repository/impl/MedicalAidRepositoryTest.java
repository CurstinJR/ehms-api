package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.MedicalAid;
import za.ac.cput.factory.MedicalAidFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MedicalAidRepositoryTest.java
 * Author: Curstin Rose - 220275408
 * Date: 9 April 2022
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicalAidRepositoryTest
{
    private static final MedicalAidRepository medicalAidRepository =
            MedicalAidRepository.getMedicalAidRepository();
    private static MedicalAid medicalAid1 = MedicalAidFactory
            .createMedicalAidNoAndName(1234_4567_8901_2345L, "Bonitas");

    @Test
    @Order(1)
    void getMedicalAidRepository()
    {
        MedicalAidRepository medicalAidRepositoryMock = MedicalAidRepository.getMedicalAidRepository();

        assertEquals(medicalAidRepositoryMock.hashCode(), medicalAidRepository.hashCode());
    }

    @Test
    @Order(2)
    void save()
    {
        MedicalAid savedMedicalAid = medicalAidRepository.save(medicalAid1);
        Long medicalAidNo = savedMedicalAid.getMedicalAidNo();

        assertEquals(medicalAidNo, medicalAid1.getMedicalAidNo());
    }

    @Test
    @Order(3)
    void findById()
    {
        MedicalAid medicalAid = medicalAidRepository
                .findById(medicalAid1.getMedicalAidNo())
                .orElseThrow();

        assertNotNull(medicalAid);
    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<MedicalAid> medicalAids = medicalAidRepository.findAll();
        assertEquals(1, medicalAids.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long medicalAidNo = medicalAid1.getMedicalAidNo();
        String medicalAidName = medicalAid1.getMedicalAidName();

        medicalAid1.setMedicalAidName("Discovery");
        MedicalAid updateMedicalAid = medicalAidRepository.update(medicalAid1);

        assertEquals(medicalAidNo, updateMedicalAid.getMedicalAidNo());
        assertNotEquals(medicalAidName, updateMedicalAid.getMedicalAidName());
        assertEquals(medicalAid1, updateMedicalAid);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean medicalAidExists = medicalAidRepository.existsById(medicalAid1.getMedicalAidNo());

        assertTrue(medicalAidExists);
    }

    @Test
    @Order(7)
    void deleteById()
    {
        medicalAidRepository.deleteById(medicalAid1.getMedicalAidNo());

        assertTrue(medicalAidRepository.findAll().isEmpty());
    }
}