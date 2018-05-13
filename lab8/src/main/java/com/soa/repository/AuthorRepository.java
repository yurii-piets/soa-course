package com.soa.repository;

import com.soa.domain.Author;
import com.soa.repository.def.AbstractRepository;

public class AuthorRepository extends AbstractRepository<Author> {

    public AuthorRepository() {
        super(Author.class);
    }
}
