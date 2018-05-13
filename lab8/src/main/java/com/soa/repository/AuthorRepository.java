package com.soa.repository;

import com.soa.domain.Author;
import com.soa.repository.def.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AuthorRepository extends AbstractRepository<Author> {

    public AuthorRepository() {
        super(Author.class);
    }

    public Collection<Author> zad1() {
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
    
    public Collection<Author> zad3() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT author FROM Rent as rent " +
                "JOIN rent.reader as czyt " +
                "JOIN rent.book as ks " +
                "JOIN ks.author as author " +
                "WHERE czyt.name = :name AND czyt.surname = :surname");
        query.setParameter("name", "Jan");
        query.setParameter("surname", "Kowalski");
        List list = query.getResultList();
        return list;
    }

    public Collection<Author> zad4() {
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT aut.surname, count(*) as num " +
                "FROM Rent as wyp " +
                "JOIN wyp.reader as czyt " +
                "JOIN wyp.book as ks " +
                "JOIN ks.author as aut " +
                "GROUP BY aut ORDER BY num DESC");
        List resultList = query.getResultList();
        return resultList;
    }
}
