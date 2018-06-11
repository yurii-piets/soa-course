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

    List<Dragon> findAllDragons();

    List<Elf> findAllElfs();

    List<Mag> findAllMags();

    void save(UserData user);

    void save(Cave cave);

    void save(Forest forest);

    void save(Tower tower);

    void save(Dragon dragon);

    void save(Elf elf);

    void save(Mag mag);

    void update(Cave cave);

    void update(Tower tower);

    void update(Forest forest);

    void update(Dragon dragon);

    void update(Elf elf);

    void update(Mag mag);

    Cave findCaveById(Long id);

    Forest findForestById(Long id);

    Tower findTowerById(Long id);

    Dragon findDragonById(Long id);

    Elf findElfById(Long id);

    Mag findMagById(Long id);

    void deleteDragonById(Long id);

    void deleteCaveById(Long id);

    void deleteElfById(Long elfId);

    void deleteForestById(Long forestId);

    void deleteMagById(Long id);

    void deleteTowerById(Long id);
}
