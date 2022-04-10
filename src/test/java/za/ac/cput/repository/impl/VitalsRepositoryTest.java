package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Vitals;
import za.ac.cput.factory.VitalsFactory;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VitalsRepositoryTest  {
    private static VitalsRepository vitalsRepository = VitalsRepository.getVitalsRepository();
    private static Vitals vitals1 = VitalsFactory.createVitals(65.78,1.56,"High-130",46.7);

    @Test()
    @Order(1)
    void getVitalsRepository(){
        VitalsRepository vitalsRepository1 = VitalsRepository.getVitalsRepository();
        assertEquals(vitalsRepository1.hashCode(), vitalsRepository.hashCode());
    }

    @Test()
    @Order(2)
    void save(){
        Vitals saveVitals = vitalsRepository.save(vitals1);
        Long patientId = saveVitals.getVitalsId();
        assertEquals(patientId, vitals1.getVitalsId());
    }

    @Test()
    @Order(3)
    void findById()
    {
        Vitals vitals = vitalsRepository
                .findById(vitals1.getVitalsId())
                .orElseThrow();
        assertNotNull(vitals);

    }

    @Test
    @Order(4)
    void findAll()
    {
        Collection<Vitals> vitals = vitalsRepository.findAll();
        assertEquals(1, vitals.size());
    }

    @Test
    @Order(5)
    void update()
    {
        Long vitalsId = vitals1.getVitalsId();
        Double weight = vitals1.getWeight();


        vitals1.setWeight(66.52);
        Vitals updateVitals = vitalsRepository.update(vitals1);

        assertEquals(vitalsId, updateVitals.getVitalsId());
        assertNotEquals(weight, updateVitals.getBloodPressure());
        assertEquals(vitals1, updateVitals);
    }

    @Test
    @Order(6)
    void existsById()
    {
        boolean vitalsExists = vitalsRepository.existsById(vitals1.getVitalsId());

        assertTrue(vitalsExists);
    }

    @Test
    @Order(7)
    void deleteById()
    {
        vitalsRepository.deleteById(vitals1.getVitalsId());

        assertTrue(vitalsRepository.findAll().isEmpty());
    }


}