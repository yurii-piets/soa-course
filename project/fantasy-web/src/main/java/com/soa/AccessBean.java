package com.soa;

import com.soa.domain.Ownable;
import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
@ManagedBean
@SessionScoped
@Stateless
@RolesAllowed({"ADMIN", "USER"})
public class AccessBean extends AbstractManagedBean {

    @EJB
    private DataAccessService dataService;

    public boolean canCreate(String category) {
        if (FacesContext.getCurrentInstance().getExternalContext().isUserInRole(UserData.UserRole.ADMIN.toString())) {
            return true;
        }
        Integer userIndex = getCurrentUser().getIndex();
        switch (category) {
            case "Cave":
                return userIndex % 3 == 0 && userIndex % 2 != 0;
            case "Tower":
                return userIndex % 2 == 0 && userIndex % 3 != 0;
            case "Forest":
                return (userIndex % 2 == 0 && userIndex % 3 == 0) || (userIndex % 2 != 0 && userIndex % 3 != 0);
        }
        return false;
    }

    public void checkCreate(String category) throws IllegalAccessException {
        if (!canCreate(category)) {
            throw new IllegalAccessException();
        }
    }

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
        if (!hasAccess(ownable)) {
            throw new IllegalAccessException();
        }
    }

    public UserData getCurrentUser() {
        String name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        return dataService.findUserDataByLogin(name);
    }

    public boolean isIsAdmin() {
        return getCurrentUser().getRole() == UserData.UserRole.ADMIN;
    }

    @RolesAllowed("ADMIN")
    public List<String> getUsersNames() {
        return dataService.findAllUsers().stream()
                .map(UserData::getLogin)
                .collect(Collectors.toList());
    }

    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        reload();
    }
}
