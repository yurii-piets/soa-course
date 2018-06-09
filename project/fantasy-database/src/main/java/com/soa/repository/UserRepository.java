package com.soa.repository;

import com.soa.domain.UserData;
import com.soa.repository.def.AbstractRepository;

public class UserRepository extends AbstractRepository<UserData> {

    public UserRepository() {
        super(UserData.class);
    }
}
