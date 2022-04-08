package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LabTestTest {

    @Test
    public void test() {

        LabTest lt1 = new LabTest.Builder()
                .testId(78945612)
                .testName("Xray")
                .testSampleDate(LocalDate.of(2022, 5, 15))
                .testFee(BigDecimal.valueOf(475))
                .build();
        System.out.println(lt1);
        LabTest lt2 = new LabTest.Builder()
                .testId(7893147)
                .testName("Blood checking")
                .testSampleDate(LocalDate.of(2022, 10, 28))
                .testFee(BigDecimal.valueOf(275))
                .build();
        System.out.println(lt2);

        LabTest lt3 = new LabTest.Builder()
                .testId(89945612)
                .testName("Eyes Checking")
                .testSampleDate(LocalDate.of(2021, 2, 10))
                .testFee(BigDecimal.valueOf(875))
                .build();
        System.out.println(lt3);
    }
}