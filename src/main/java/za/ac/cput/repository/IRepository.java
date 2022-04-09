package za.ac.cput.repository;

import java.util.Collection;
import java.util.Optional;

/**
 * IRepository.java
 * Author: Curstin Rose - 220275408
 * Date: 5 April 2022
 * @param <T>
 * @param <ID>
 */
public interface IRepository<T, ID>
{
    T save(T entity);

    Optional<T> findById(ID id);

    Collection<T> findAll();

    T update(T entity);

    boolean deleteById(ID id);

    boolean existsById(ID id);
}
