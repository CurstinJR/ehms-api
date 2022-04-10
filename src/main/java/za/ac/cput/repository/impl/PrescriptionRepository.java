package za.ac.cput.repository.impl;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */
import za.ac.cput.entity.Prescription;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PrescriptionRepository  implements IPrescription {


    private  static PrescriptionRepository  repository=null;
    private Set<Prescription> prescriptionDB=null;

    private  PrescriptionRepository()
    {
        prescriptionDB= new HashSet<Prescription>();
    }
    public static PrescriptionRepository getRepository()
    {
        if(repository==null)
        {
            repository= new PrescriptionRepository();
        }
        return repository;
    }


    @Override
    public Prescription save(Prescription prescription) {
        boolean success=prescriptionDB.add(prescription);
        if(!success)
            return null;
        return prescription;

    }

    @Override
    public Optional<Prescription> findById(Long id) {

            Prescription  optional=prescriptionDB.stream().
                    filter(e ->e.getPrescriptionNumber().equals(id)).findAny().orElse(null);

            return Optional.of(optional);

    }

    @Override
    public Collection<Prescription> findAll()
    {

        return null;
    }

    @Override
    public Prescription update(Prescription prescription) {
        Optional<Prescription> currentPrescription=findById(prescription.getPrescriptionNumber());
        if (currentPrescription!=null)
        {

            prescriptionDB.remove(currentPrescription);
            prescriptionDB.add(prescription);
            System.out.println("update"+currentPrescription);
        }
        return  prescription;
    }

    @Override
    public boolean deleteById(Long aLong)
    {
        return false;
    }

    @Override
    public void delete(Prescription prescription)
    {
        Optional<Prescription> deleteGender=findById(prescription.getPrescriptionNumber());
        if (deleteGender==null)
        {
            System.out.println("not Deleted");
        }
        prescriptionDB.remove(Optional.of(deleteGender));
        System.out.println("Deleted");

    }

    @Override
    public boolean existsById(Long id)
    {
        Optional<Prescription> deletePrescription= findById(id);
        if (deletePrescription ==null)
        {
            return false;
        }

        return true;
    }

    @Override
    public Set<Prescription> getAll() {

        return prescriptionDB;
    }
}
