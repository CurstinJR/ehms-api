package za.ac.cput.factory.payment;

import za.ac.cput.entity.payment.MedicalAid;

import java.time.LocalDate;

/**
 * MedicalAidFactory.java
 * Author: Curstin Rose - 220275408
 * Date: 8 April 2022
 */
public class MedicalAidFactory {
    public static MedicalAid createMedicalAid(Long claimId, LocalDate claimDate, String claimType,
                                              String medicalAidName, long medicalAidNo) {
        return new MedicalAid.Builder()
                .claimId(claimId)
                .claimDate(claimDate)
                .claimType(claimType)
                .medicalAidName(medicalAidName)
                .medicalAidNo(medicalAidNo)
                .build();
    }

    /**
     * For client usage, the patient only needs to enter the medicalAidNo and
     * the medical aid name.
     *
     * @param medicalAidNo
     * @param medicalAidName
     * @return
     */
    public static MedicalAid createMedicalAidNoAndName(long medicalAidNo, String medicalAidName) {
        return new MedicalAid.Builder()
                .medicalAidNo(medicalAidNo)
                .medicalAidName(medicalAidName)
                .build();
    }
}
