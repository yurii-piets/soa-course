package com.soa.repository;

import com.soa.domain.Author;
import com.soa.repository.def.AbstractRepository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Date;

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
}
