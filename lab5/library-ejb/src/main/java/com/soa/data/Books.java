package com.soa.data;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Setter
@XmlRootElement(name = "books")
public class Books {

    @XmlElement(name = "book")
    private List<Book> books = new ArrayList<>();

    public boolean addBook(Book book){
        return books.add(book);
    }

    @XmlTransient
    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(String isbn){
        return books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
