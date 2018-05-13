package com.soa.repository;

import com.soa.domain.Author;
import com.soa.repository.def.AbstractRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

public class AuthorRepository extends AbstractRepository<Author> {

    public AuthorRepository() {
        super(Author.class);
    }

    @Override
    public Collection<Author> findByCriteria() {
        EntityManager em = factory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> pet = cq.from(Author.class);
        cq.where(cb.equal(pet.get("name"), "Joanne"));

        TypedQuery<Author> query = em.createQuery(cq);
        List<Author> authors = query.getResultList();

        return authors;
    }
}
