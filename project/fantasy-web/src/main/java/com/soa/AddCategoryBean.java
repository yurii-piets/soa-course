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

    @ManagedProperty("#{param.userLogin}")
    private String userLogin;

    @ManagedProperty("#{param.disabledMode}")
    private boolean disabledMode;

    public void changeMode() {
        this.disabledMode = !disabledMode;
    }

    public boolean isDisabledMode() {
        return disabledMode;
    }

    public void save() throws IOException, IllegalAccessException {
        UserData owner = null;
        if (accessBean.getCurrentUser().getRole() == UserData.UserRole.ADMIN) {
            if (userLogin != null) {
                owner = dataService.findUserDataByLogin(userLogin);
            }
        } else {
            owner = accessBean.getCurrentUser();
        }

        switch (category) {
            case "Cave":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findCaveById(categoryId));
                } else {
                    accessBean.checkCreate(category);
                }

                dataService.update(new Cave(categoryId, mainParameter, owner));
                break;
            case "Forest":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findForestById(categoryId));
                } else {
                    accessBean.checkCreate(category);
                }

                dataService.update(new Forest(categoryId, mainParameter, owner));
                break;
            case "Tower":
                if (categoryId != null && categoryId != 0L) {
                    accessBean.checkAccess(dataService.findTowerById(categoryId));
                } else {
                    accessBean.checkCreate(category);
                }

                dataService.update(new Tower(categoryId, mainParameter, owner));
                break;

        }

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect("/fantasy/view/faces/catalog.xhtml");
    }
}
