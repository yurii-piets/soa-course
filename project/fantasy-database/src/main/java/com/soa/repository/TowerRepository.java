package com.soa.repository;

import com.soa.domain.categories.Tower;
import com.soa.repository.def.AbstractRepository;

public class TowerRepository extends AbstractRepository<Tower> {

    public TowerRepository() {
        super(Tower.class);
    }
}
