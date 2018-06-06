package com.soa.database.service;

import com.soa.database.domain.UserData;

import javax.ejb.Local;

@Local
public interface DataAccessService {

    void save(UserData user);
}
