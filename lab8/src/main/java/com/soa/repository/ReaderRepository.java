package com.soa.repository;

import com.soa.domain.Reader;
import com.soa.repository.def.AbstractRepository;

public class ReaderRepository extends AbstractRepository<Reader> {

    public ReaderRepository() {
        super(Reader.class);
    }
}
