package com.soa;

import com.soa.domain.Power;
import com.soa.domain.hero.Dragon;
import com.soa.service.DataAccessService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
@ManagedBean
@RequestScoped
public class DragonBean extends AbstractHeroBean {

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

    @Override
    public void modify() throws IOException {
        dataService.update(Dragon.builder()
                .id(dragonId)
                .name(name)
                .gold(gold)
                .color(color)
                .power(power)
                .cave(dataService.findCaveById(caveId))
                .build());
        reload();
    }

    @Override
    public void delete() throws IOException {
        dataService.deleteDragonById(dragonId);
        reload();
    }

    public void deleteCave() throws IOException {
        dataService.deleteCaveById(caveId);
        reload();
    }
}
