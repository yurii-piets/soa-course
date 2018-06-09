package com.soa.repository;

import com.soa.domain.UserData;
import com.soa.repository.def.AbstractRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class UserRepository extends AbstractRepository<UserData> {

    public UserRepository() {
        super(UserData.class);
    }
}
