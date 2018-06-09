package com.soa.repository;

import com.soa.domain.categories.Forest;
import com.soa.repository.def.AbstractRepository;

public class ForestRepository extends AbstractRepository<Forest> {

    public ForestRepository() {
        super(Forest.class);
    }
}
