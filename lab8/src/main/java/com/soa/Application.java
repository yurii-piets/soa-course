package com.soa;

import com.soa.domain.Author;
import com.soa.repository.AuthorRepository;
import com.soa.repository.def.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

public class Application {

    public static void main(String[] args) {
//        new MockDataBuilder();
        Repository<Author> authorRepository = new AuthorRepository();
        CriteriaBuilder criteriaBuilder = authorRepository.getCriteriaBuilder();

        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root from = criteriaQuery.from(Author.class);

        Collection<Author> byCriteria = authorRepository.findByCriteria(criteriaBuilder);
        System.out.println(authorRepository.findAll());
    }
}
