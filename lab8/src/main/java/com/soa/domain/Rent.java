package com.soa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Rent {

    public static final String RENT_ID_COLUMN = "rent_id";

    public static final String RENT_TIME_COLUMN = "rent_time";

    @Id
    @GeneratedValue
    @Column(name = RENT_ID_COLUMN)
    private Long id;

    @Column(name = RENT_TIME_COLUMN)
    private Date rentTime;

    @OneToOne
    @JoinColumn(name = Book.BOOK_ID_COLUMN)
    private Book book;

    @OneToOne
    @JoinColumn(name = Reader.READER_ID_COLUMN)
    private Reader reader;

    public Rent(Book book, Reader reader, Date rentTime) {
        this.rentTime = rentTime;
        this.book = book;
        this.reader = reader;
    }

    public Rent(Book book, Reader reader) {
        this.rentTime = new Date();
        this.book = book;
        this.reader = reader;
    }
}
