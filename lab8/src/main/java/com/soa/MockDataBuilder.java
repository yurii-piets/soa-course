package com.soa;

import com.google.common.collect.Lists;
import com.soa.domain.Author;
import com.soa.domain.Book;
import com.soa.domain.Reader;
import com.soa.domain.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class MockDataBuilder {

    private final EntityManagerFactory factory;

    public MockDataBuilder() {
        this.factory = getEntityManagerFactory();
        insertMockData();
    }

    private EntityManagerFactory getEntityManagerFactory() {
        Map<String, String> env = System.getenv();
        Map<String, Object> config = new HashMap<>();
        config.put("javax.persistence.jdbc.user", env.get("PG_USER"));
        config.put("javax.persistence.jdbc.password", env.get("PG_PASSWORD"));

        return Persistence.createEntityManagerFactory("SOA_LAB8", config);
    }

    public void insertMockData() {
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Author author1 = new Author("Joanne", "Rowling");
        Book book1 = new Book("Harry Potter 1", author1);
        Book book2 = new Book("Harry Potter 2", author1);
        Book book3 = new Book("Harry Potter 3", author1);
        Book book4 = new Book("Harry Potter 4", author1);
        Book book5 = new Book("Harry Potter 5", author1);
        Book book6 = new Book("Harry Potter 6", author1);
        Book book7 = new Book("Harry Potter 7", author1);

        Author author2 = new Author("Alan", "Mycroft");
        Book book8 = new Book("Java 8 in Action.", author2);

        Author author3 = new Author("Bruce", "Eckel");
        Book book9 = new Book("Thinking in Java", author3);

        Reader reader1 = new Reader("Jan", "Kowalski");
        Reader reader2 = new Reader("John", "Smith");
        Reader reader3 = new Reader("Krzystof", "Krawczyk");

        Rent rent1 = new Rent(book1, reader1);
        Rent rent2 = new Rent(book2, reader2);
        Rent rent3 = new Rent(book3, reader3);

        transaction.begin();
        Lists.newArrayList(author1, author2, author3).forEach(em::persist);
        Lists.newArrayList(book1, book2, book3, book4, book5, book6, book7, book8,book9).forEach(em::persist);
        Lists.newArrayList(reader1, reader2, reader3).forEach(em::persist);
        Lists.newArrayList(rent1, rent2, rent3).forEach(em::persist);
        transaction.commit();
    }
}
