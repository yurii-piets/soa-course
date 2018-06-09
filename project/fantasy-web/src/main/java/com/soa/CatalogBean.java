package com.soa;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Data
@ManagedBean
@SessionScoped
public class CatalogBean {

    @EJB
    private DataAccessService dataService;

    private List<Cave> caves;

    private List<Forest> forests;

    private List<Tower> towers;

    @PostConstruct
    public void postConstruct() {
        caves = dataService.findAllCaves();
        forests = dataService.findAllForest();
        towers = dataService.findAllTower();
    }
}
