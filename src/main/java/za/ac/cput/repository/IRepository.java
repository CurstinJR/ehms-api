package za.ac.cput.repository;

import java.util.Optional;

/*
IRepository.java
Author: Curstin Rose - 220275408
Date: 5 April 2022
 */
public interface IRepository<T, ID>
{
    T save(T entity);
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    T update(T entity, ID id);
    void delete(T entity);
    boolean existsById(ID id);
}
