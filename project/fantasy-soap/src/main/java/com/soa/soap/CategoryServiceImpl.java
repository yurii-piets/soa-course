package com.soa.soap;

import com.soa.service.DataAccessService;
import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.soap.CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private DataAccessService dataService;

    @Override
    public void saveCave(WSCave wsCave) {
        dataService.save(wsCave.toCave());
    }

    @Override
    public void saveTower(WSTower wsTower) {
        dataService.save(wsTower.toTower());
    }

    @Override
    public void saveForest(WSForest wsForest) {
        dataService.save(wsForest.toForest());
    }
}
