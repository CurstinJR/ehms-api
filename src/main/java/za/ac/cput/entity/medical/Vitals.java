package za.ac.cput.entity.medical;

import lombok.*;
import za.ac.cput.entity.user.Patient;

import javax.persistence.*;

/*
Vitals.java
Author: Tarren-Marc Adams - 214041794
Date: 7 April 2022
 */
@Entity
@Table(name = "vitals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Vitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vitalsId;
    private Double weight;
    private Double height;
    private String bloodPressure;
    private Double temperature;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
