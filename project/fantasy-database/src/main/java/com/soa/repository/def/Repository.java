package com.soa.repository.def;

import java.util.Collection;
import java.util.List;

public interface Repository<T> {

    List<T> findAll();

    void save(T user);

    void save(Collection<T> entities);

    void delete(T entity);

    void delete(Collection<T> entities);
}
