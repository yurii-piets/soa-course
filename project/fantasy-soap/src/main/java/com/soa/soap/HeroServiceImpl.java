package com.soa.soap;

import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;
import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.soap.HeroService")
public class HeroServiceImpl implements HeroService {

    @EJB
    private DataAccessService dataService;

    @Override
    public void saveDragon(WSDragon dragonRequest) {
        Dragon dragon = dragonRequest.toDragon();
        dragon.setCave(dataService.findCaveById(dragonRequest.getCaveId()));
        dataService.save(dragon);
    }

    @Override
    public void saveElf(WSElf elfRequest) {
        Elf elf = elfRequest.toElf();
        elf.setForest(dataService.findForestById(elfRequest.getForestId()));
        dataService.save(elf);
    }

    @Override
    public void saveMag(WSMag magRequest) {
        Mag mag = magRequest.toMag();
        mag.setTower(dataService.findTowerById(magRequest.getTowerId()));
        dataService.save(mag);
    }

    @Override
    public void modifyGold(Long dragonId, Integer gold) {
        Dragon dragon = dataService.findDragonById(dragonId);
        dragon.setGold(gold);
        dataService.update(dragon);
    }

    @Override
    public void modifyArrows(Long elfId, Integer arrowsAmount) {
        Elf elf = dataService.findElfById(elfId);
        elf.setArrowCount(arrowsAmount);
        dataService.update(elf);
    }

    @Override
    public void modifyMana(Long magId, Integer mana) {
        Mag mag = dataService.findMagById(magId);
        mag.setMana(mana);
        dataService.update(mag);
    }
}
