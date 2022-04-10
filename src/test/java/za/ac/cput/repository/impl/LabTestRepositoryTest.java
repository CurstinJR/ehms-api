package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.LabTest;
import za.ac.cput.factory.LabTestFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LabTestRepositoryTest {
    private static LabTestRepository labTestRepository =
            LabTestRepository.getLabTestRepository();

    private static LabTest lab1 = LabTestFactory.createLabTest(
            1L,
            "test1",
            LocalDate.of(2022, 5, 16),
            BigDecimal.valueOf(399.99));

    @Test()
    @Order(1)
    void getLabTestRepository() {
        LabTestRepository labTestRepository = LabTestRepository.getLabTestRepository();
        assertEquals(labTestRepository.hashCode(), labTestRepository.hashCode());
    }

    @Test()
    @Order(2)
    void save() {
        LabTest labTest = labTestRepository.save(lab1);
        Long testId = labTest.getTestId();
        assertEquals(testId, lab1.getTestId());
        System.out.print(labTest);
    }

    @Test()
    @Order(3)
    void findById() {
        LabTest labtest = labTestRepository
                .findById(lab1.getTestId())
                .orElseThrow();
        assertNotNull(labtest);

    }

    @Test
    @Order(4)
    void findAll() {
        Collection<LabTest> labTestsList = labTestRepository.findAll();
        assertEquals(1, labTestsList.size());
    }

    @Test
    @Order(5)
    void update() {
        Long labTestId = lab1.getTestId();
        BigDecimal testFee = lab1.getTestFee();

        lab1.setTestFee(BigDecimal.valueOf(499.99));
        LabTest updateLabTest = labTestRepository.update(lab1);

        assertEquals(labTestId, updateLabTest.getTestId());
        assertNotEquals(testFee, updateLabTest.getTestFee());
        assertEquals(lab1, updateLabTest);
    }

    @Test
    @Order(6)
    void existsById() {
        boolean labTestExists = labTestRepository.existsById(lab1.getTestId());

        assertTrue(labTestExists);
    }

    @Test
    @Order(7)
    void deleteById() {
        labTestRepository.deleteById(lab1.getTestId());

        assertTrue(labTestRepository.findAll().isEmpty());
    }
}