package com.soa.repository.def;

import com.soa.domain.hero.Hero;

import java.util.Comparator;

public abstract class HeroRepository<H extends Hero> extends AbstractRepository<H> {

    protected HeroRepository(Class<H> type) {
        super(type);
    }

    public abstract H findReachest();

    public H findStrongest() {
        return findAll().stream()
                .max(Comparator.comparing(h -> h.getPower().getIntValue()))
                .orElse(null);
    }
}
