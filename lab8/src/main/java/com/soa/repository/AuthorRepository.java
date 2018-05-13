package com.soa.repository;

import com.soa.domain.Author;
import com.soa.repository.def.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class AuthorRepository extends AbstractRepository<Author> {

    public AuthorRepository() {
        super(Author.class);
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
