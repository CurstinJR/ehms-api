package za.ac.cput.factory;

import za.ac.cput.entity.MedicalAid;

import java.time.LocalDate;

public class MedicalAidFactory
{
    public static MedicalAid createMedicalAid(long claimId, String claimType, LocalDate claimDate,
                                              long medicalAidNo, String medicalAidName)
    {
        return new MedicalAid.Builder()
                .claimId(claimId)
                .claimType(claimType)
                .claimDate(claimDate)
                .medicalAidNo(medicalAidNo)
                .medicalAidName(medicalAidName)
                .build();
    }
}
