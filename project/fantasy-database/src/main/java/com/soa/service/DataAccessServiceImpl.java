package com.soa.service;

import com.soa.domain.UserData;
import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.repository.CaveRepository;
import com.soa.repository.DragonRepository;
import com.soa.repository.ElfRepository;
import com.soa.repository.ForestRepository;
import com.soa.repository.MagRepository;
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

    @EJB
    private ElfRepository elfRepository;

    @EJB
    private MagRepository magRepository;

    @Override
    public List<Cave> findAllCaves() {
        List<Cave> caves = caveRepository.findAll();
        List<Dragon> dragons = dragonRepository.findAll();

        caves.forEach(c -> c.setDragons(dragons.stream()
                        .filter(d -> d.getCave().getId().equals(c.getId())
                        ).collect(Collectors.toList())
                )
        );
        return caves;
    }

    @Override
    public List<Forest> findAllForests() {
        List<Forest> forests = forestRepository.findAll();
        List<Elf> elfs = elfRepository.findAll();

        forests.forEach(c -> c.setElfs(elfs.stream()
                        .filter(d -> d.getForest().getId().equals(c.getId())
                        ).collect(Collectors.toList())
                )
        );
        return forests;
    }

    @Override
    public List<Tower> findAllTowers() {
        List<Tower> towers = towerRepository.findAll();
        List<Mag> mags = magRepository.findAll();

        towers.forEach(c -> c.setMags(mags.stream()
                        .filter(d -> d.getTower().getId().equals(c.getId())
                        ).collect(Collectors.toList())
                )
        );
        return towers;
    }

    @Override
    public void update(Cave cave) {
        caveRepository.update(cave);
    }

    @Override
    public void update(Forest forest) {
        forestRepository.update(forest);
    }

    @Override
    public void update(Tower tower) {
        towerRepository.update(tower);
    }

    @Override
    public void save(UserData user) {
        userRepository.save(user);
    }

    @Override
    public void save(Elf elf) {
        elfRepository.save(elf);
    }

    @Override
    public void save(Mag mag) {
        magRepository.save(mag);
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
    public void update(Elf elf) {
        elfRepository.update(elf);
    }

    @Override
    public void update(Mag mag) {
        magRepository.update(mag);
    }

    @Override
    public Cave findCaveById(Long id) {
        return caveRepository.findById(id);
    }

    @Override
    public void deleteDragonById(Long id) {
        Dragon dragon = dragonRepository.findById(id);
        dragon.getCave().getDragons().remove(dragon);
        dragonRepository.delete(dragon);
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

    @Override
    public Forest findForestById(Long forestId) {
        return forestRepository.findById(forestId);
    }

    @Override
    public void deleteElfById(Long id) {
        Elf elf = elfRepository.findById(id);
        elf.getForest().getElfs().remove(elf);
        elfRepository.delete(elf);
    }

    @Override
    public void deleteForestById(Long id) {
        List<Elf> linkedElfs = elfRepository.findAll()
                .stream()
                .filter(e -> e.getForest().getId().equals(id))
                .collect(Collectors.toList());
        elfRepository.delete(linkedElfs);
        forestRepository.deleteById(id);
    }

    @Override
    public Tower findTowerById(Long towerId) {
        return towerRepository.findById(towerId);
    }

    @Override
    public void deleteMagById(Long id) {
        Mag mag = magRepository.findById(id);
        mag.getTower().getMags().remove(mag);
        magRepository.delete(mag);
    }

    @Override
    public void deleteTowerById(Long id) {
        List<Mag> linkedMags = magRepository.findAll()
                .stream()
                .filter(m -> m.getTower().getId().equals(id))
                .collect(Collectors.toList());
        magRepository.delete(linkedMags);
        towerRepository.deleteById(id);
    }
}
