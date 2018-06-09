package com.soa.repository.def;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    T findById(Long id);

    void save(T user);

    void save(Collection<T> entities);

    void update(T entity);

    void delete(T entity);

    void delete(Collection<T> entities);

    void deleteById(Long id);
}
