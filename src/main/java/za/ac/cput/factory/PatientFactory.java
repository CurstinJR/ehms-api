package za.ac.cput.factory;

import za.ac.cput.entity.Patient;
import za.ac.cput.util.Helper;

public class PatientFactory
{
    public static Patient createPatient(String patientName, String patientSurname)
    {
        Long patientId = Helper.generateId();

        return new Patient.Builder()
                .patientId(patientId)
                .patientName(patientName)
                .patientSurname(patientSurname)
                .build();
    }
}
