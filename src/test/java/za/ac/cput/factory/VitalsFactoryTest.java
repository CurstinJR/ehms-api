package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.factory.medical.VitalsFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
VitalsFactoryTest.java
Author: Tarren-Marc Adams - 214041794
Date: 8 April 2022
 */

class VitalsFactoryTest {

    @Test
    public void addVitals() {
        Vitals vitals = VitalsFactory.createVitals(65.78, 1.56, "High-130", 46.7);
        assertNotNull(vitals);
    }


}