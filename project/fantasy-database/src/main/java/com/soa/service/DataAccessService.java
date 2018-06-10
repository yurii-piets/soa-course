package com.soa.service;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Dragon;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DataAccessService {

    List<Cave> findAllCaves();

    List<Dragon> findAllDragons();

    List<Forest> findAllForest();

    List<Tower> findAllTower();

    void save(UserData user);

    void save(Dragon dragon);

    void update(Dragon dragon);

    Cave findCaveById(Long id);

    void deleteDragonById(Long id);

    void deleteCaveById(Long id);
}
