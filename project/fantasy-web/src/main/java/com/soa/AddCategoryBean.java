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

    @ManagedProperty("#{param.categoryId}")
    private Long categoryId;

    @ManagedProperty("#{param.category}")
    private String category;

    @ManagedProperty("#{param.mainParameter}")
    private Integer mainParameter;

    public void save() throws IOException {
        switch (category) {
            case "Cave":
                dataService.update(new Cave(categoryId, mainParameter));
                break;
            case "Forest":
                dataService.update(new Forest(categoryId, mainParameter));
                break;
            case "Tower":
                dataService.update(new Tower(categoryId, mainParameter));
                break;

        }

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("/fantasy/view/faces/catalog.xhtml");
    }
}
