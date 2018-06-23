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

    @EJB
    private AccessBean accessBean;

    @ManagedProperty("#{param.heroId}")
    private Long heroId;

    @ManagedProperty("#{param.heroType}")
    private String heroType;

    @ManagedProperty("#{param.categoryId}")
    private Long categoryId;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.integerParameter}")
    private Integer integerParameter;

    @ManagedProperty("#{param.power}")
    private Power power;

    @ManagedProperty("#{param.color}")
    private Dragon.Color color;

    @ManagedProperty("#{param.bowType}")
    private Elf.BowType bowType;

    @ManagedProperty("#{param.element}")
    private Mag.Element element;

    public void save() throws IOException, IllegalAccessException {
        if(heroId == 0){
            heroId = null;
        }
        switch (heroType) {
            case "Dragon":
                if (heroId != null) {
                    accessBean.checkAccess(dataService.findDragonById(heroId));
                }
                Dragon dragon = Dragon.builder()
                        .id(heroId)
                        .name(name)
                        .gold(integerParameter)
                        .color(color)
                        .power(power)
                        .cave(dataService.findCaveById(categoryId))
                        .build();
                if (heroId == null || heroId == 0L) {
                    dataService.save(dragon);
                } else {
                    dataService.update(dragon);
                }
                break;
            case "Elf":
                if (heroId != null) {
                    accessBean.checkAccess(dataService.findElfById(heroId));
                }
                Elf elf = Elf.builder()
                        .id(heroId)
                        .name(name)
                        .arrowCount(integerParameter)
                        .bowType(bowType)
                        .power(power)
                        .forest(dataService.findForestById(categoryId))
                        .build();
                if (heroId == null || heroId == 0L) {
                    dataService.save(elf);
                } else {
                    dataService.update(elf);
                }
                break;
            case "Mag":
                if (heroId != null) {
                    accessBean.checkAccess(dataService.findMagById(heroId));
                }
                Mag mag = Mag.builder()
                        .id(heroId)
                        .name(name)
                        .mana(integerParameter)
                        .element(element)
                        .power(power)
                        .tower(dataService.findTowerById(categoryId))
                        .build();
                if (heroId == null || heroId == 0L) {
                    dataService.save(mag);
                } else {
                    dataService.update(mag);
                }
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
