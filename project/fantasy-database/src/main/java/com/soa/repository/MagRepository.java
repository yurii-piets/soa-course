package com.soa.repository;

import com.soa.domain.hero.Mag;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MagRepository extends AbstractRepository<Mag> {

    protected MagRepository() {
        super(Mag.class);
    }
}
