package com.soa.service;

import com.soa.domain.UserData;

import javax.ejb.Remote;

@Remote
public interface DataAccessService {

    void save(UserData user);
}
