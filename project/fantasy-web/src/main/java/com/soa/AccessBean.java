package com.soa;

import com.soa.domain.Ownable;
import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.security.Principal;

@Data
@ManagedBean
@SessionScoped
@Stateless
public class AccessBean {

    @EJB
    private DataAccessService dataService;

    public boolean hasAccess(Ownable ownable) {
        if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole(UserData.UserRole.ADMIN.toString())) {
            return true;
        }
        UserData userData = ownable.getOwner();
        Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        if (userData == null || principal == null) {
            return false;
        }
        return principal.getName().equals(userData.getLogin());
    }

    public void checkAccess(Ownable ownable) throws IllegalAccessException {
        if(!hasAccess(ownable)) {
            throw new IllegalAccessException();
        }
    }

    public UserData getCurrentUser(){
        String name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        return dataService.findUserDataByLogin(name);
    }
}
