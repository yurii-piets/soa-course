package com.soa.service;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Dragon;
import com.soa.repository.CaveRepository;
import com.soa.repository.DragonRepository;
import com.soa.repository.ForestRepository;
import com.soa.repository.TowerRepository;
import com.soa.repository.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Remote(DataAccessService.class)
public class DataAccessServiceImpl implements DataAccessService {

    @EJB
    private CaveRepository caveRepository;

    @EJB
    private ForestRepository forestRepository;

    @EJB
    private TowerRepository towerRepository;

    @EJB
    private UserRepository userRepository;

    @EJB
    private DragonRepository dragonRepository;

    @Override
    public List<Cave> findAllCaves() {
        return caveRepository.findAll();
    }

    @Override
    public List<Forest> findAllForest() {
        return forestRepository.findAll();
    }

    @Override
    public List<Tower> findAllTower() {
        return towerRepository.findAll();
    }

    @Override
    public void save(UserData user) {
        userRepository.save(user);
    }

    @Override
    public void save(Dragon dragon) {
        dragonRepository.save(dragon);
    }

    @Override
    public void update(Dragon dragon) {
        dragonRepository.update(dragon);
    }

    @Override
    public Cave findCaveById(Long id) {
        return caveRepository.findById(id);
    }

    @Override
    public void deleteDragonById(Long id) {
        dragonRepository.deleteById(id);
    }

    @Override
    public void deleteCaveById(Long id) {
        List<Dragon> linkedDragons = dragonRepository.findAll()
                .stream()
                .filter(d -> d.getCave().getId().equals(id))
                .collect(Collectors.toList());
        dragonRepository.delete(linkedDragons);
        caveRepository.deleteById(id);
    }
}
