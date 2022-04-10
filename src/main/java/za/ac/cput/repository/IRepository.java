package za.ac.cput.repository;

import java.util.Optional;

public interface IRepository<T, ID>
{
    T save(T entity);
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    T update(T entity, ID id);
    void delete(T entity);
    boolean existsById(ID id);
}
