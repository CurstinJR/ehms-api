package za.ac.cput.factory.medical;
/*
DiagnosisFactory.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 08 April 2022
 */

import za.ac.cput.entity.medical.Diagnosis;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class DiagnosisFactory {
    public static Diagnosis createDiagnosis(String diagnosisName, String diagnosisType, LocalDate date) {
        Long diagnosisId = Helper.generateId();

        return new Diagnosis.Builder()
                .diagnosisId(diagnosisId)
                .diagnosisName(diagnosisName)
                .diagnosisType(diagnosisType)
                .date(date)
                .build();
    }


}
