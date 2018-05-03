package com.soa.data;

import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Setter
@XmlRootElement
public class Books {

    @XmlElement
    private List<Book> book = new ArrayList<>();

    public boolean addBook(Book book){
        return this.book.add(book);
    }

    @XmlTransient
    public List<Book> getBook() {
        return book;
    }

    public Book getBookById(String isbn){
        return book.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
