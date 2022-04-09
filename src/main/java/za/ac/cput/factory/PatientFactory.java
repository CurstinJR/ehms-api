package za.ac.cput.factory;

import za.ac.cput.entity.Patient;

public class PatientFactory
{
    public static Patient createPatient(long patientId, String patientName, String patientSurname)
    {
        return new Patient.Builder()
                .patientId(patientId)
                .patientName(patientName)
                .patientSurname(patientSurname)
                .build();
    }
}
