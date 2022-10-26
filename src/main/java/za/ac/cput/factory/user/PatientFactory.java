package za.ac.cput.factory.user;

import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.entity.user.Patient;

/**
 * PatientFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class PatientFactory {
    public static Patient createPatient(Long id, String firstName, String lastName, Vitals vitals) {
        return Patient.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .vitals(vitals)
                .build();
    }
}
