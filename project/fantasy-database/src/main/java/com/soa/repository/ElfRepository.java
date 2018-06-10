package com.soa.repository;

import com.soa.domain.hero.Elf;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ElfRepository extends AbstractRepository<Elf> {

    protected ElfRepository() {
        super(Elf.class);
    }
}
