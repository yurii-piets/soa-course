package com.soa.repository.def;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;

public interface Repository<T> {

    Collection<T> findAll();
    Collection<T> findByCriteria();
    CriteriaBuilder getCriteriaBuilder();

    void save(T entity);
    void save(Collection<T> entities);

    void delete(T entity);
    void delete(Collection<T> entities);
}
