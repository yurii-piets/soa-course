package com.soa.repository;

import com.soa.domain.Author;
import com.soa.domain.Reader;
import com.soa.repository.def.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReaderRepository extends AbstractRepository<Reader> {

    public ReaderRepository() {
        super(Reader.class);
    }

    public Collection<Reader> zad1() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT reader FROM Rent as r " +
                "JOIN r.reader as reader " +
                "JOIN r.book as ks " +
                "JOIN ks.author as aut " +
                "WHERE aut.name = :name AND aut.surname = :surname AND r.rentTime > :data1 AND r.rentTime < :data2");
        query.setParameter("name", "Joanne");
        query.setParameter("surname", "Rowling");
        query.setParameter("data1", new Date(2018,1,1));
        query.setParameter("data2", new Date(2018,6,1));
        return query.getResultList();
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
