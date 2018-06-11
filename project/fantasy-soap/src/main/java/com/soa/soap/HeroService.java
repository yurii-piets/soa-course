package com.soa.soap;

import com.soa.request.WSDragonRequest;
import com.soa.request.WSElfRequest;
import com.soa.request.WSMagRequest;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HeroService {

    @WebMethod
    void saveDragon(WSDragonRequest dragon);

    @WebMethod
    void saveElf(WSElfRequest elf);

    @WebMethod
    void saveMag(WSMagRequest mag);

    @WebMethod
    void modifyGold(Long dragonId, Integer gold);

    @WebMethod
    void modifyArrows(Long elfId, Integer arrowsAmount);

    @WebMethod
    void modifyMana(Long magId, Integer mana);
}
