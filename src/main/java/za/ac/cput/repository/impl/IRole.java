package za.ac.cput.repository.impl;

import za.ac.cput.entity.Role;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IRole extends IRepository<Role, Long> {



    public Set<Role> getAll();
}