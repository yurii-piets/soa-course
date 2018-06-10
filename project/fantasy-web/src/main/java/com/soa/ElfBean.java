package com.soa;

import com.soa.domain.Power;
import com.soa.domain.hero.Elf;
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
public class ElfBean extends AbstractHeroBean {

    @EJB
    private DataAccessService dataService;

    @ManagedProperty("#{param.elfId}")
    private Long elfId;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.arrowCount}")
    private Integer arrowCount;

    @ManagedProperty("#{param.bowType}")
    private Elf.BowType bowType;

    @ManagedProperty("#{param.power}")
    private Power power;

    @ManagedProperty("#{param.forestId}")
    private Long forestId;

    @Override
    public void modify() throws IOException {
        dataService.update(Elf.builder()
                .id(elfId)
                .name(name)
                .arrowCount(arrowCount)
                .bowType(bowType)
                .power(power)
                .forest(dataService.findForestById(forestId))
                .build());
        reload();
    }

    @Override
    public void delete() throws IOException {
        dataService.deleteElfById(elfId);
        reload();
    }

    public void deleteForest() throws IOException {
        dataService.deleteForestById(forestId);
        reload();
    }
}
