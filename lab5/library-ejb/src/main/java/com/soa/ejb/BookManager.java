package com.soa.ejb;

import com.soa.data.Book;
import com.soa.data.Books;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


@Startup
@Singleton
public class BookManager {

    private Books books;

    private File file = new File("C:/Users/Comarch/devnull/soa/lab5/library-ejb/src/main/resources/books.xml");

    private Logger logger = LogManager.getLogger(BookManager.class);

    @PostConstruct
    private void postConstruct() {
        try {
            JAXBContext context = JAXBContext.newInstance(Books.class);
            Unmarshaller u = context.createUnmarshaller();
            this.books = (Books) u.unmarshal(file);
        } catch (Exception e) {
            this.books = new Books();
        }

    }

    @PreDestroy
    public void preDestroy() {
        try {
            JAXBContext context = JAXBContext.newInstance(Books.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(this.books, file);
        } catch (Exception e) {
            logger.error("Unexpected:", e);
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
        return books.getBooks();
    }
}
