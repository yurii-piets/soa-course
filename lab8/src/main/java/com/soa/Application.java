package com.soa;

import com.soa.domain.Author;
import com.soa.domain.Reader;
import com.soa.repository.AuthorRepository;
import com.soa.repository.ReaderRepository;

import java.util.Collection;

public class Application {

    private static final boolean create_drop = false;

    public static void main(String[] args) {
        if (create_drop) {
            new MockDataBuilder();
        } else {
            zad1();
            zad2();
            zad3();
            zad4();
        }
    }

    private static void zad4() {
        AuthorRepository authorRepository = new AuthorRepository();
        Collection<Author> authors = authorRepository.zad4();
        System.out.println(authors);
    }

    private static void zad3() {
        AuthorRepository authorRepository = new AuthorRepository();
        Collection<Author> authors = authorRepository.zad3();
        System.out.println(authors);
    }

    private static void zad2() {
        ReaderRepository readerRepository = new ReaderRepository();
        Collection<Reader> readers = readerRepository.zad2();
        System.out.println(readers);
    }

    private static void zad1() {
        AuthorRepository authorRepository = new AuthorRepository();
        Collection<Author> authors = authorRepository.zad1();
        System.out.println(authors);
    }
}
