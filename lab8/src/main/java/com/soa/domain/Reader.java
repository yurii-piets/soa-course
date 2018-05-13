package com.soa.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Reader {

    public static final String READER_ID_COLUMN = "reader_id";

    @Id
    @GeneratedValue
    @Column(name = READER_ID_COLUMN)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
