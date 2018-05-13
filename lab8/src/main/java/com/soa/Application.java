package com.soa;

import com.soa.domain.Author;
import com.soa.domain.Book;
import com.soa.domain.Reader;
import com.soa.domain.Rent;
import com.soa.repository.AuthorRepository;
import com.soa.repository.BookRepository;
import com.soa.repository.ReaderRepository;
import com.soa.repository.RentRepository;
import com.soa.repository.def.Repository;

import java.util.Collection;
import java.util.Scanner;

public class Application {

    private static final boolean create_drop = false;

    public static void main(String[] args) {
        if (create_drop) {
            new MockDataBuilder();
        } else {
            run();
        }
    }

    private static void run() {
        System.out.println("1. Get book");
        System.out.println("2. Add book");
        System.out.println("3. Get readers");
        System.out.println("4. Add reader");
        System.out.println("5. Get authors");
        System.out.println("6. Add author");
        System.out.println("7. Add rent");
        System.out.println("8. Get rents");
        System.out.println("9. Run task 1");
        System.out.println("10. Run task 2");
        System.out.println("11. Run task 3");
        System.out.println("12. Run task 4");

        while (!Thread.interrupted()) {
            System.out.println("Enter command id:");
            Scanner scanner = new Scanner(System.in);
            Integer command = scanner.nextInt();
            switch (command) {
                case 1: {
                    Repository<Book> bookRepository = new BookRepository();
                    Collection<Book> books = bookRepository.findAll();
                    displayBooks(books);
                    break;
                }
                case 2: {
                    System.out.println("Not implemented yet.");
                    break;
                }
                case 3: {
                    Repository<Reader> readerRepository = new ReaderRepository();
                    Collection<Reader> readers = readerRepository.findAll();
                    displayReaders(readers);
                    break;
                }
                case 4: {
                    Repository<Reader> readerRepository = new ReaderRepository();
                    System.out.println("To add reader enter name and surname.");
                    String name = scanner.next();
                    String surname = scanner.next();
                    readerRepository.save(new Reader(name, surname));
                    break;
                }
                case 5: {
                    Repository<Author> authorRepository = new AuthorRepository();
                    Collection<Author> authors = authorRepository.findAll();
                    displayAuthors(authors);
                    break;
                }
                case 6:
                    System.out.println("Not implemented yet.");
                    break;
                case 7:
                    System.out.println("Not implemented yet.");
                    break;
                case 8: {
                    Repository<Rent> rentRepository = new RentRepository();
                    Collection<Rent> rents = rentRepository.findAll();
                    displayRents(rents);
                    break;
                }
                case 9:
                    zad1();
                    break;
                case 10:
                    zad2();
                    break;
                case 11:
                    zad3();
                    break;
                case 12:
                    zad4();
                    break;

            }
        }
    }

    private static void displayRents(Collection<Rent> rents) {
        System.out.println("Books: ");
        System.out.println("|\tId\t|\tBook title\t|\tReader|");
        rents.stream()
                .map(r -> "|\t" + r.getId() + "\t|\t" + r.getBook().getName() + "\t|\t" + r.getReader().getName() + " " + r.getReader().getSurname() + "\t|")
                .forEach(System.out::println);
    }

    private static void displayBooks(Collection<Book> books) {
        System.out.println("Books: ");
        System.out.println("|\tId\t|\tBook title\t|\tAuthor|");
        books.stream()
                .map(a -> "|\t" + a.getId() + "\t|\t" + a.getName() + "\t|\t" + a.getAuthor().getName() + " " + a.getAuthor().getSurname() + "\t|")
                .forEach(System.out::println);
    }

    private static void zad4() {
        AuthorRepository authorRepository = new AuthorRepository();
        Collection<Author> authors = authorRepository.zad4();
        displayAuthors(authors);
    }

    private static void zad3() {
        AuthorRepository authorRepository = new AuthorRepository();
        Collection<Author> authors = authorRepository.zad3();
        displayAuthors(authors);
    }

    private static void zad2() {
        ReaderRepository readerRepository = new ReaderRepository();
        Collection<Reader> readers = readerRepository.zad2();
        System.out.println(readers);
        displayReaders(readers);
    }

    private static void zad1() {
        ReaderRepository readerRepository = new ReaderRepository();
        Collection<Reader> readers = readerRepository.zad1();
        displayReaders(readers);
    }

    private static void displayAuthors(Collection<Author> authors) {
        System.out.println("Authors: ");
        System.out.println("|\tId\t|\tName\t|\tSurname|");
        authors.stream()
                .map(a -> "|\t" + a.getId() + "\t|\t" + a.getName() + "\t|\t" + a.getSurname() + "\t|")
                .forEach(System.out::println);
    }

    private static void displayReaders(Collection<Reader> readers) {
        System.out.println("Readers:");
        System.out.println("|\tId\t|\tName\t|\tSurname|");
        readers.stream()
                .map(r -> "|\t" + r.getId() + "\t|\t" + r.getName() + "\t|\t" + r.getSurname() + "\t|")
                .forEach(System.out::println);
    }
}
