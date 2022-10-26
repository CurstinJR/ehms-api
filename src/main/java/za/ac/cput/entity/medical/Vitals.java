package za.ac.cput.entity.medical;

import lombok.*;

import javax.persistence.Embeddable;

/*
Vitals.java
Author: Tarren-Marc Adams - 214041794
Date: 7 April 2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Embeddable
public class Vitals {
    private Double weight;
    private Double height;
    private String bloodPressure;
    private Double temperature;
}
