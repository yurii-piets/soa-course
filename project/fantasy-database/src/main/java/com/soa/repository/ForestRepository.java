package com.soa.repository;

import com.soa.domain.categories.Forest;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ForestRepository extends AbstractRepository<Forest> {

    public ForestRepository() {
        super(Forest.class);
    }
}
