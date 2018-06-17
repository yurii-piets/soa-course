package com.soa;

import com.soa.domain.UserData;
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

    @EJB
    private AccessBean accessBean;

    @ManagedProperty("#{param.categoryId}")
    private Long categoryId;

    @ManagedProperty("#{param.category}")
    private String category;

    @ManagedProperty("#{param.mainParameter}")
    private Integer mainParameter;

    public void save() throws IOException, IllegalAccessException {
        switch (category) {
            case "Cave":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findCaveById(categoryId));
                }
                dataService.update(new Cave(categoryId, mainParameter, accessBean.getCurrentUser().getRole() != UserData.UserRole.ADMIN ? accessBean.getCurrentUser() : null));
                break;
            case "Forest":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findForestById(categoryId));
                }
                dataService.update(new Forest(categoryId, mainParameter, accessBean.getCurrentUser().getRole() != UserData.UserRole.ADMIN ? accessBean.getCurrentUser() : null));
                break;
            case "Tower":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findTowerById(categoryId));
                }
                dataService.update(new Tower(categoryId, mainParameter, accessBean.getCurrentUser().getRole() != UserData.UserRole.ADMIN ? accessBean.getCurrentUser() : null));
                break;

        }

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("/fantasy/view/faces/catalog.xhtml");
    }
}
