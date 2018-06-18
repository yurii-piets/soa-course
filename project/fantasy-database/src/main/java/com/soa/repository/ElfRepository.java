package com.soa.repository;

import com.soa.domain.hero.Elf;
import com.soa.repository.def.HeroRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import static com.soa.domain.hero.Elf.REACHEST_ELF_QUERY_NAME;

@Stateless
@LocalBean
public class ElfRepository extends HeroRepository<Elf> {

    protected ElfRepository() {
        super(Elf.class);
    }

    @Override
    public Elf findReachest() {
        return (Elf) entityManager.createNamedQuery(REACHEST_ELF_QUERY_NAME).getResultList().get(0);
    }
}
