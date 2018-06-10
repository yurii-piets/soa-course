package com.soa;

import com.soa.domain.Power;
import com.soa.domain.hero.Mag;
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
public class MagBean extends AbstractHeroBean {

    @EJB
    private DataAccessService dataService;

    @ManagedProperty("#{param.magId}")
    private Long magId;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.mana}")
    private Integer mana;

    @ManagedProperty("#{param.element}")
    private Mag.Element element;

    @ManagedProperty("#{param.power}")
    private Power power;

    @ManagedProperty("#{param.towerId}")
    private Long towerId;

    @Override
    public void modify() throws IOException {
        dataService.update(Mag.builder()
                .id(magId)
                .name(name)
                .mana(mana)
                .element(element)
                .power(power)
                .tower(dataService.findTowerById(towerId))
                .build());
        reload();
    }

    @Override
    public void delete() throws IOException {
        dataService.deleteMagById(magId);
        reload();
    }

    public void deleteTower() throws IOException {
        dataService.deleteTowerById(towerId);
        reload();
    }
}
