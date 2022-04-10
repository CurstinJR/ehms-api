package za.ac.cput.repository.impl;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Prescription;
import za.ac.cput.factory.PrescriptionFactory;
import za.ac.cput.repository.impl.PrescriptionRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class PrescriptionRepositoryTest {
    private static PrescriptionRepository repository= PrescriptionRepository.getRepository();
    private static Prescription prescription= PrescriptionFactory.createPrescription("Pandoc",56.98,"help with  pains headaches, toothaches and pains associated with colds and flu.","Paracetamol 500mg");

    @Test
    void a_save()
    {
        Prescription created =repository.save(prescription);
        assertEquals(prescription.getPrescriptionNumber(),created .getPrescriptionNumber());
        //System.out.println(created);
        System.out.println("created"+created);

    }

    @Test
    void b_findById() {
        Prescription created =repository.save(prescription);
        Optional<Prescription> READ =repository.findById(prescription.getPrescriptionNumber());
        assertNotNull(READ);
        System.out.println("findById"+READ);
    }

    @Test
    void c_update() {
        Prescription created =repository.save(prescription);
        Prescription update= new Prescription.Builder().copy(prescription).setName("Uterine")
                .setBigDecimal(45.89).setDescription("It  helps restore good gut bacteria and reduces the risk of developing infectious diarrhoea.")
                .setType("Health Probiotic ").build();
        assertNotNull(repository.update(update));
        System.out.println("update"+update);
    }

    @Test
    void z_delete() {

    }

    @Test
    void d_existsById() {
        Prescription created =repository.save(prescription);
        boolean id=repository.existsById(prescription.getPrescriptionNumber());
        assertTrue(id);
        System.out.println("existsById "+id);
    }

    @Test
    void e_getAll() {
        Prescription created =repository.save(prescription);
        assertNotNull(repository.getAll());
        System.out.println("List"+repository.getAll());
    }
}