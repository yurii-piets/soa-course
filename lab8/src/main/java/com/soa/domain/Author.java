package com.soa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Author {

    public static final String AUTHOR_ID_COLUMN = "author_id";

    @Id
    @GeneratedValue
    @Column(name = AUTHOR_ID_COLUMN)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;
}
