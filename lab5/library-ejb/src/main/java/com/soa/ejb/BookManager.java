package com.soa.ejb;

import com.soa.data.Book;
import com.soa.data.Books;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Startup
@Singleton
public class BookManager {

    private Books books;

    @PostConstruct
    private void postConstruct() {
        try{
            JAXBContext context = JAXBContext.newInstance(Books.class);
            Unmarshaller u = context.createUnmarshaller();
            File input = new File("C:/Users/plague/programming-projects/java/java-ee/Idea/soa/lab5/library-ejb/src/main/resources/books.xml");
            this.books = (Books) u.unmarshal(input);
        } catch (Exception e){
            this.books = new Books();
        }

    }

    public void rent(String isbn) throws IllegalAccessException {
        Book book = books.getBookById(isbn);
        if (book.isRented()) {
            throw new IllegalAccessException("Books is already rented.");
        }
        if (book.isReserved()) {
            throw new IllegalAccessException("Books is already reserved.");
        }
        book.setRented(true);
    }

    public void reserve(String isbn) throws IllegalAccessException {
        Book book = books.getBookById(isbn);
        if (book.isRented()) {
            throw new IllegalAccessException("Books is already rented.");
        }
        if (book.isReserved()) {
            throw new IllegalAccessException("Books is already reserved.");
        }
        book.setReserved(true);
    }

    public void retrieve(String isbn) {
        Book book = books.getBookById(isbn);
        book.setReserved(false);
        book.setRented(false);
    }

    public List<Book> getBooks() {
        return books.getBook();
    }
}
