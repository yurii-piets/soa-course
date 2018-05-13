package com.soa.repository.def;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> findAll();

    void save(T entity);
    void save(Collection<T> entities);

    void delete(T entity);
    void delete(Collection<T> entities);
}
