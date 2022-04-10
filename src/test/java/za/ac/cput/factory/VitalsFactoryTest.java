package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Vitals;

import static org.junit.jupiter.api.Assertions.*;

class VitalsFactoryTest {

    @Test
    public void addVitals(){
        Vitals vitals = VitalsFactory.createVitals(65.78,1.56,"High",46.7);
        assertNotNull(vitals);
    }



}