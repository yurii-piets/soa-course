package com.soa;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@Data
@ManagedBean
@RequestScoped
public class DragonBean {

    @EJB
    private DataAccessService dataService;

    @ManagedProperty("#{param.dragonId}")
    private Long dragonId;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.gold}")
    private Integer gold;

    @ManagedProperty("#{param.color}")
    private Dragon.Color color;

    @ManagedProperty("#{param.power}")
    private Power power;

    @ManagedProperty("#{param.caveId}")
    private Long caveId;

    public void modify() {
        dataService.update(Dragon.builder()
                .id(dragonId)
                .name(name)
                .gold(gold)
                .color(color)
                .power(power)
                .cave(dataService.findCaveById(caveId))
                .build());
    }

    public void delete() {
        dataService.deleteDragonById(dragonId);
    }

    public void deleteCave() {
        dataService.deleteCaveById(caveId);
    }
}
