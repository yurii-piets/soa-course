package com.soa.repository;

import com.soa.domain.categories.Cave;
import com.soa.repository.def.AbstractRepository;

public class CaveRepository extends AbstractRepository<Cave> {

    public CaveRepository() {
        super(Cave.class);
    }
}
