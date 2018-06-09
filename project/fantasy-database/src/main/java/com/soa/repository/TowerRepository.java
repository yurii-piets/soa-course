package com.soa.repository;

import com.soa.domain.categories.Tower;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TowerRepository extends AbstractRepository<Tower> {

    public TowerRepository() {
        super(Tower.class);
    }
}
