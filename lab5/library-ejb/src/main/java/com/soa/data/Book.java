package com.soa.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Data
@NoArgsConstructor
public class Book {

    @XmlElement
    private String isbn;

    @XmlElement
    private String title;

    @XmlElement
    private String author;

    @XmlTransient
    private boolean rented = false;

    @XmlTransient
    private boolean reserved = false;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}
