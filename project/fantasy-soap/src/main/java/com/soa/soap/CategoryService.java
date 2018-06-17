package com.soa.soap;

import com.soa.ws.category.WSCave;
import com.soa.ws.category.WSForest;
import com.soa.ws.category.WSTower;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CategoryService {

    @WebMethod
    void saveCave(WSCave wsCave);

    @WebMethod
    void saveTower(WSTower wsTower);

    @WebMethod
    void saveForest(WSForest wsForest);
}
