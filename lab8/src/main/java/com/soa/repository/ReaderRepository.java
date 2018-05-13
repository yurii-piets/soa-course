package com.soa.repository;

import com.soa.domain.Reader;
import com.soa.repository.def.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class ReaderRepository extends AbstractRepository<Reader> {

    public ReaderRepository() {
        super(Reader.class);
    }

    public Collection<Reader> zad2() {
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("SELECT red FROM Rent as ren " +
                "JOIN ren.reader as red " +
                "JOIN ren.book as b " +
                "WHERE b.name = :name");
        query.setParameter("name", "Harry Potter 2");
        List resultList = query.getResultList();
        return resultList;
    }
}
