package com.soa;

import com.soa.domain.categories.Cave;
import com.soa.domain.categories.Forest;
import com.soa.domain.categories.Tower;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@Data
@ManagedBean
@RequestScoped
public class AddCategoryBean {

    @EJB
    private DataAccessService dataService;

    @ManagedProperty("#{param.category}")
    private String category;

    private Integer mainParameter;

    public void save() throws IOException {
        switch (category) {
            case "Cave":
                dataService.save(new Cave(mainParameter));
                break;
            case "Forest":
                dataService.save(new Tower(mainParameter));
                break;
            case "Tower":
                dataService.save(new Forest(mainParameter));
                break;

        }

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("/fantasy/view/faces/catalog.xhtml");
    }
}
