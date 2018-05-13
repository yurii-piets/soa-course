package com.soa;

import com.soa.domain.Author;
import com.soa.repository.AuthorRepository;
import com.soa.repository.def.Repository;

import java.util.Collection;

public class Application {

    public static void main(String[] args) {
//        new MockDataBuilder();
        Repository<Author> authorRepository = new AuthorRepository();

        Collection<Author> byCriteria = authorRepository.findByCriteria();
        System.out.println(byCriteria);
    }
}
