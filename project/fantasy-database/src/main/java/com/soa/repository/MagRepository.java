package com.soa.repository;

import com.soa.domain.hero.Mag;
import com.soa.repository.def.HeroRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.soa.domain.hero.Mag.REACHEST_MAG_QUERY_NAME;

@Stateless
@LocalBean
public class MagRepository extends HeroRepository<Mag> {

    protected MagRepository() {
        super(Mag.class);
    }

    @Override
    public Mag findReachest() {
        return (Mag) entityManager.createNamedQuery(REACHEST_MAG_QUERY_NAME).getResultList().get(0);
    }
}
