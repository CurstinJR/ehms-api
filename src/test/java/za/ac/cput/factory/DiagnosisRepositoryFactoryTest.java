package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.medical.Diagnosis;
import za.ac.cput.factory.medical.DiagnosisFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiagnosisRepositoryFactoryTest {

    @Test
    public void addDiagnosis() {
        Diagnosis dia1 = DiagnosisFactory.createDiagnosis("Arthritis", "X-Ray", LocalDate.of(2022, 7, 25));
        assertNotNull(dia1);
        System.out.println("Diagnosis created");
    }

    @Test
    void testEquality() {
        Diagnosis dia1 = DiagnosisFactory.createDiagnosis("Tumor", "MRI SCAN", LocalDate.of(2022, 6, 17));
        Diagnosis dia2 = DiagnosisFactory.createDiagnosis("Heart disease", "PET SCAN", LocalDate.of(2022, 5, 7));
        Diagnosis dia3 = dia1;

        assertNotEquals(dia1, dia2);
    }

    @Test
    void testIdentity() {
        Diagnosis dia1 = DiagnosisFactory.createDiagnosis("Tumor", "MRI SCAN", LocalDate.of(2022, 6, 17));
        Diagnosis dia2 = DiagnosisFactory.createDiagnosis("Heart disease", "PET SCAN", LocalDate.of(2022, 5, 7));
        Diagnosis dia3 = dia1;

        assertSame(dia1, dia3);
        assertSame(dia1.getDate(), dia1.getDate());

        assertNotSame(dia1.getDate(), dia2.getDate());
    }

}