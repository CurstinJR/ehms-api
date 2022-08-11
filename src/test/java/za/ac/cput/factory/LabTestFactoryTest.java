package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.medical.LabTest;
import za.ac.cput.factory.medical.LabTestFactory;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LabTestFactoryTest {

    @Test
    public void test() {
        LabTest lab1 = LabTestFactory.createLabTest(218L
                , "Xray"
                , LocalDate.of(2022, 3, 10)
                , BigDecimal.valueOf(405.99));
        System.out.println(lab1.toString());
        assertNotNull(lab1);

        LabTest lab2 = LabTestFactory.createLabTest(450L
                , "PRC"
                , LocalDate.of(2021, 5, 31)
                , BigDecimal.valueOf(850.99));
        System.out.println(lab2.toString());
        assertNotNull(lab2);

        LabTest lab3 = LabTestFactory.createLabTest(150L
                , "HIV"
                , LocalDate.of(2019, 1, 21)
                , BigDecimal.valueOf(250.99));
        System.out.println(lab3.toString());
        assertNotNull(lab3);
    }
}