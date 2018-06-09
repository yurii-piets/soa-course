package com.soa.service;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DataAccessService {

    List<Cave> findAllCaves();
    List<Forest> findAllForest();
    List<Tower> findAllTower();

    void save(UserData user);
}
