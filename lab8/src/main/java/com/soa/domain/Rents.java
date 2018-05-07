package com.soa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Entity
public class Rents {

    public static final String RENT_ID_COLUMN = "rent_id";

    @Id
    @GeneratedValue
    @Column(name = RENT_ID_COLUMN)
    private Long id;

    private Date rentTime;

    @OneToOne
    @JoinColumn(name = Book.BOOK_ID_COLUMN)
    private Book book;

    @OneToOne
    @JoinColumn(name = Reader.READER_ID_COLUMN)
    private Reader reader;
}
