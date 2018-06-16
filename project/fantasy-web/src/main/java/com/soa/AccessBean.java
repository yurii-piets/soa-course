package com.soa;

import com.soa.domain.Ownable;
import com.soa.domain.UserData;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.security.Principal;

@Data
@ManagedBean
@SessionScoped
public class AccessBean {

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
}
