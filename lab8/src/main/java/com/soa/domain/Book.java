package com.soa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Book {

    public static final String BOOK_ID_COLUMN = "book_id";

    @Id
    @GeneratedValue
    @Column(name = BOOK_ID_COLUMN)
    private Long id;

    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = Author.AUTHOR_ID_COLUMN)
    private Author author;
}
