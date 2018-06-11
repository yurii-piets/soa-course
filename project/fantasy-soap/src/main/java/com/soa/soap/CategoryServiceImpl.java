package com.soa.soap;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.service.DataAccessService;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "com.soa.soap.CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @EJB
    private DataAccessService dataService;

    @Override
    public void saveCave(Cave cave) {
        dataService.save(cave);
    }

    @Override
    public void saveTower(Tower tower) {
        dataService.save(tower);
    }

    @Override
    public void saveForest(Forest forest) {
        dataService.save(forest);
    }
}
