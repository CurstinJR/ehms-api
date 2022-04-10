package za.ac.cput.repository.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Diagnosis;
import za.ac.cput.factory.DiagnosisFactory;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

/*
DiagnosisRepositoryTest.java
Author: Ngonidzaishe Erica Chipato- 218327315
Date: 09 April 2022
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DiagnosisRepositoryTest

{

        private static DiagnosisRepository diagnosisRepository = DiagnosisRepository.getDiagnosisRepository();
        private static Diagnosis dia1 = DiagnosisFactory.createDiagnosis("Arthritis","X-Ray",LocalDate.of(2022, 7, 26));

        @Test
        @Order(1)
        void getDiagnosisRepository()
        {
            DiagnosisRepository diagnosisRepository = DiagnosisRepository.getDiagnosisRepository();

            assertEquals(diagnosisRepository.hashCode(), diagnosisRepository.hashCode());
        }

        @Test
        @Order(2)
        void save()
        {
            Diagnosis savedDiagnosis = diagnosisRepository.save(dia1);
            Long patientId = savedDiagnosis.getDiagnosisId();

            assertEquals(patientId, dia1.getDiagnosisId());
        }

        @Test
        @Order(3)
        void findById()
        {
            Diagnosis appointment = diagnosisRepository
                    .findById(dia1.getDiagnosisId())
                    .orElseThrow();

            assertNotNull(appointment);
        }

        @Test
        @Order(4)
        void findAll()
        {
            Collection<Diagnosis> appointments = diagnosisRepository.findAll();
            assertEquals(1, appointments.size());
        }

        @Test
        @Order(5)
        void update()
        {
            Long diagnosisId = dia1.getDiagnosisId();
            LocalDate date = LocalDate.of(2022, 05, 16);


            dia1.setDate(LocalDate.of(2022, 5, 15));
            Diagnosis updateAppointment = diagnosisRepository.update(dia1);

            assertEquals(diagnosisId, updateAppointment.getDiagnosisId());
        }

        @Test
        @Order(6)
        void existsById()
        {
            boolean appointmentExists = diagnosisRepository.existsById(dia1.getDiagnosisId());

            assertTrue(appointmentExists);
        }

        @Test
        @Order(7)
        void deleteById()
        {
            diagnosisRepository.deleteById(dia1.getDiagnosisId());

            assertTrue(diagnosisRepository.findAll().isEmpty());
        }
}