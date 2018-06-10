package com.soa.service;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DataAccessService {

    List<Cave> findAllCaves();

    List<Forest> findAllForests();

    List<Tower> findAllTowers();

    void save(Cave cave);

    void save(Tower cave);

    void save(Forest cave);

    void save(UserData user);

    void update(Dragon dragon);

    void update(Elf elf);

    void update(Mag mag);

    Cave findCaveById(Long id);

    void deleteDragonById(Long id);

    void deleteCaveById(Long id);

    Forest findForestById(Long forestId);

    void deleteElfById(Long elfId);

    void deleteForestById(Long forestId);

    Tower findTowerById(Long towerId);

    void deleteMagById(Long id);

    void deleteTowerById(Long id);
}
