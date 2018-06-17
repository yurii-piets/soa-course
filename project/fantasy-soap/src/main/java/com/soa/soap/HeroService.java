package com.soa.soap;

import com.soa.ws.hero.WSDragon;
import com.soa.ws.hero.WSElf;
import com.soa.ws.hero.WSMag;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HeroService {

    @WebMethod
    void saveDragon(WSDragon dragon);

    @WebMethod
    void saveElf(WSElf elf);

    @WebMethod
    void saveMag(WSMag mag);

    @WebMethod
    void modifyGold(Long dragonId, Integer gold);

    @WebMethod
    void modifyArrows(Long elfId, Integer arrowsAmount);

    @WebMethod
    void modifyMana(Long magId, Integer mana);
}
