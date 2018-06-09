package com.soa.repository;

import com.soa.domain.hero.Dragon;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class DragonRepository extends AbstractRepository<Dragon> {

    public DragonRepository() {
        super(Dragon.class);
    }
}
