package za.ac.cput.factory.medical;


import za.ac.cput.entity.medical.Vitals;
import za.ac.cput.util.Helper;

/*
VitalsFactory.java
Author: Tarren-Marc Adams - 214041794
Date: 10 April 2022
 */
public class VitalsFactory {
    public static Vitals createVitals(Double weight, Double height, String bloodPressure, Double temperature) {

        Long vitalsId = Helper.generateId();

        return new Vitals.Builder()
                .vitalsId(vitalsId)
                .weight(weight)
                .height(height)
                .bloodPressure(bloodPressure)
                .temperature(temperature)
                .build();
    }


}
