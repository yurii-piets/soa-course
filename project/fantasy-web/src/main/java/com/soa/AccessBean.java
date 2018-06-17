package com.soa;

import com.soa.domain.Ownable;
import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import lombok.Data;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.security.Principal;
import java.util.stream.Collectors;

@Data
@ManagedBean
@SessionScoped
@Stateless
public class AccessBean {

    @EJB
    private DataAccessService dataService;

    @RolesAllowed({"ADMIN", "USER"})
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

    @RolesAllowed({"ADMIN", "USER"})
    public void checkAccess(Ownable ownable) throws IllegalAccessException {
        if(!hasAccess(ownable)) {
            throw new IllegalAccessException();
        }
    }

    @RolesAllowed({"ADMIN", "USER"})
    public UserData getCurrentUser(){
        String name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        return dataService.findUserDataByLogin(name);
    }

    @RolesAllowed({"ADMIN", "USER"})
    public boolean isIsAdmin() {
        return getCurrentUser().getRole() == UserData.UserRole.ADMIN;
    }

    @RolesAllowed("ADMIN")
    public Object getGetUsersNames() {
        return dataService.findAllUsers().stream()
                .map(UserData::getLogin)
                .collect(Collectors.toList());
    }
}
