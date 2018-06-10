package com.soa;

import com.soa.domain.Power;
import com.soa.domain.categories.Cave;
import com.soa.domain.hero.Dragon;
import com.soa.domain.hero.Elf;
import com.soa.domain.hero.Mag;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

import java.util.List;

@Data
@ManagedBean
@RequestScoped
public class AddHeroBean {

    @EJB
    private DataAccessService dataService;

    @ManagedProperty("#{param.heroType}")
    private String heroType;

    @ManagedProperty("#{param.categoryId}")
    private Long categoryId;

    private String name;

    private Integer integerParameter;

    private Power power;

    private Dragon.Color color;

    private Elf.BowType bowType;

    private Mag.Element element;

    public void save() throws IOException {
        switch (heroType) {
            case "Dragon":
                dataService.save(Dragon.builder()
                        .name(name)
                        .gold(integerParameter)
                        .color(color)
                        .power(power)
                        .cave(dataService.findCaveById(categoryId))
                        .build());
                break;
            case "Elf":
                dataService.save(Elf.builder()
                        .name(name)
                        .arrowCount(integerParameter)
                        .bowType(bowType)
                        .power(power)
                        .forest(dataService.findForestById(categoryId))
                        .build());
                break;
            case "Mag":
                dataService.save(Mag.builder()
                        .name(name)
                        .mana(integerParameter)
                        .element(element)
                        .power(power)
                        .tower(dataService.findTowerById(categoryId))
                        .build());
                break;
        }

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("/fantasy/view/faces/catalog.xhtml");
    }

    public Dragon.Color[] getColorValues() {
        return Dragon.Color.values();
    }

    public Elf.BowType[] getBowTypes() {
        return Elf.BowType.values();
    }

    public Power[] getPowerValues() {
        return Power.values();
    }

    public Mag.Element[] getElements() {
        return Mag.Element.values();
    }

    public List<Cave> getCaves() {
        return dataService.findAllCaves();
    }
}
