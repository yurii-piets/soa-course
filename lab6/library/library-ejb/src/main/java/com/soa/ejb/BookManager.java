package com.soa.ejb;

import com.soa.data.Book;
import com.soa.data.Books;
import com.soa.jms.NotificationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Startup
@Singleton
public class BookManager {

    private Books books;

    private File file = new File("C:/Users/plague/programming-projects/java/java-ee/Idea/soa/lab6/library/library-ejb/src/main/resources/books.xml");

    private Logger logger = LogManager.getLogger(BookManager.class);

    @Inject
    private NotificationService notificationService;

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
            String message = "Book [" + book.getIsbn() +  "] is already rented.";
            notificationService.sendNotification(message);
            throw new IllegalAccessException(message);
        }
        if (book.isReserved()) {
            String message = "Book [" + book.getIsbn() +  "] already reserved.";
            notificationService.sendNotification(message);
            throw new IllegalAccessException(message);
        }
        book.setRented(true);
        notificationService.sendNotification("Book [" + book.getIsbn() +  "] was rented.");
    }

    public void reserve(String isbn) throws IllegalAccessException {
        Book book = books.getBookById(isbn);
        if (book.isRented()) {
            String message = "Book [" + book.getIsbn() +  "] is already rented.";
            notificationService.sendNotification(message);
            throw new IllegalAccessException(message);
        }
        if (book.isReserved()) {
            String message = "Book [" + book.getIsbn() +  "] already reserved.";
            notificationService.sendNotification(message);
            throw new IllegalAccessException(message);
        }
        book.setReserved(true);
        notificationService.sendNotification("Book [" + book.getIsbn() +  "] was reserved.");
    }

    public void retrieve(String isbn) {
        Book book = books.getBookById(isbn);
        book.setReserved(false);
        book.setRented(false);
        notificationService.sendNotification("Book [" + book.getIsbn() +  "] was retried.");
    }

    public List<Book> getBooks() {
        return books.getBooks();
    }
}
