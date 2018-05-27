package com.soa.dao;

import com.soa.domain.Film;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class FilmDao extends BasicDAO<Film, Long> {

    public FilmDao(Datastore ds) {
        super(ds);
    }
}
