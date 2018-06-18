package com.soa.repository;

import com.soa.domain.hero.Dragon;
import com.soa.repository.def.HeroRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.soa.domain.hero.Dragon.REACHEST_DRAGON_QUERY_NAME;

@LocalBean
@Stateless
public class DragonRepository extends HeroRepository<Dragon> {

    public DragonRepository() {
        super(Dragon.class);
    }

    public Dragon findReachest() {
        return (Dragon) entityManager.createNamedQuery(REACHEST_DRAGON_QUERY_NAME).getSingleResult();
    }
}
