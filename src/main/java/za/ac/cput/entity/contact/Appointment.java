package za.ac.cput.entity.contact;

import lombok.*;
import za.ac.cput.entity.user.Patient;

import javax.persistence.*;
import java.time.LocalDate;

/*
Appointment.java
Author: Tarren-Marc Adams - 214041794
Date: 6 April 2022
 */
@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String appointmentTime;
    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;



}
