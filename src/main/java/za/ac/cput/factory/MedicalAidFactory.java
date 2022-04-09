package za.ac.cput.factory;

import za.ac.cput.entity.MedicalAid;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class MedicalAidFactory
{
    public static MedicalAid createMedicalAid(String claimType, LocalDate claimDate,
                                              long medicalAidNo, String medicalAidName)
    {
        Long claimId = Helper.generateId();
        return new MedicalAid.Builder()
                .claimId(claimId)
                .claimType(claimType)
                .claimDate(claimDate)
                .medicalAidNo(medicalAidNo)
                .medicalAidName(medicalAidName)
                .build();
    }
}
