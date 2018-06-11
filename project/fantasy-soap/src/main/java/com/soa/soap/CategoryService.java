package com.soa.soap;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CategoryService {

    @WebMethod
    void saveCave(Cave cave);

    @WebMethod
    void saveTower(Tower tower);

    @WebMethod
    void saveForest(Forest forest);
}
