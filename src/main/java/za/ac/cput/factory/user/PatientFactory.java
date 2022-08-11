package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Patient;
import za.ac.cput.util.Helper;

/**
 * PatientFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class PatientFactory {
    public static Patient createPatient(String patientName, String patientSurname) {
        Long patientId = Helper.generateId();

        return new Patient.Builder()
                .patientId(patientId)
                .patientName(patientName)
                .patientSurname(patientSurname)
                .build();
    }
}
