package com.soa.rest.service;

import com.soa.ws.category.response.WSCaveResponse;
import com.soa.ws.category.response.WSForestResponse;
import com.soa.ws.category.response.WSTowerResponse;
import com.soa.ws.hero.response.WSDragonResponse;
import com.soa.ws.hero.response.WSElfResponse;
import com.soa.ws.hero.response.WSMagResponse;

import javax.ejb.Stateless;

@Stateless
public interface TranslateService {

    WSCaveResponse translate(WSCaveResponse wsCave);

    WSForestResponse translate(WSForestResponse wsForest);

    WSTowerResponse translate(WSTowerResponse wsTower);

    WSDragonResponse translate(WSDragonResponse wsDragon);

    WSElfResponse translate(WSElfResponse wsElf);

    WSMagResponse translate(WSMagResponse wsMag);
}
