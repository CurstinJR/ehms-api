package za.ac.cput.repository;
/*

AUTHOR Chantal Niyonzima
Student Number 217267815
Date April 9 2022
 */

import za.ac.cput.entity.Role;
import za.ac.cput.repository.impl.IRole;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class RoleRepository implements IRole {

    private  static RoleRepository  repository=null;
    private Set<Role> roleDB=null;

    private  RoleRepository()
    {
        roleDB= new HashSet<Role>();
    }
    public static RoleRepository getRepository()
    {
        if(repository==null)
        {
            repository= new RoleRepository();
        }
        return repository;
    }
    @Override
    public Role save(Role role) {
        boolean success=roleDB.add(role);
        if(!success)
            return null;
        return role;
    }

    @Override
    public Optional<Role> findById(Long id) {

        Role optional=roleDB.stream().
                filter(e ->e.getRoleId().equals(id)).findAny().orElse(null);

        return Optional.of(optional);
    }

    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Role update(Role role, Long id) {
        Optional<Role> currentPrescription=findById(role.getRoleId());
        if (currentPrescription!=null)
        {

            roleDB.remove(currentPrescription);
            roleDB.add(role);
        }
        return  role;
    }

    @Override
    public void delete(Role role) {
        Optional<Role> deleteGender=findById(role.getRoleId());
        if (deleteGender==null)
        {
            System.out.println("not Deleted");
        }
        roleDB.remove(Optional.of(deleteGender));
        System.out.println("Deleted");

    }

    @Override
    public boolean existsById(Long id) {
        Optional<Role> deletePrescription= findById(id);
        if (deletePrescription ==null)
        {
            return false;
        }

        return true;
    }

    @Override
    public Set<Role> getAll() {
        return roleDB;
    }
}
