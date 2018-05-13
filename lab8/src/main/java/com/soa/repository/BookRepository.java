package com.soa.repository;

import com.soa.domain.Book;
import com.soa.repository.def.AbstractRepository;

public class BookRepository extends AbstractRepository<Book> {

    public BookRepository() {
        super(Book.class);
    }
}
