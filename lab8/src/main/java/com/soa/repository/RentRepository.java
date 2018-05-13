package com.soa.repository;

import com.soa.domain.Rent;
import com.soa.repository.def.AbstractRepository;

public class RentRepository extends AbstractRepository<Rent> {

    public RentRepository() {
        super(Rent.class);
    }
}
