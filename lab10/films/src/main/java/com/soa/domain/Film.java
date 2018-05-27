package com.soa.domain;

import lombok.Data;
import org.mongodb.morphia.annotations.Id;

import static com.soa.controller.FilmsController.BASIC_URL;

@Data
public class Film {

    private static Long staticId = 0L;

    @Id
    private Long id = ++staticId;

    private String name;

    private String year;

    private String uri;

    public Film() {
        this.uri = BASIC_URL + id;
    }
}
