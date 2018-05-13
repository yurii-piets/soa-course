package com.soa;

import com.soa.domain.Author;
import com.soa.repository.AuthorRepository;

import java.util.Collection;

public class Application {

    private static final boolean create_drop = false;

    public static void main(String[] args) {
        if (create_drop) {
            new MockDataBuilder();
        } else {
            AuthorRepository authorRepository = new AuthorRepository();
            Collection<Author> authors = authorRepository.zad1();
            System.out.println(authors);
        }
    }
}
