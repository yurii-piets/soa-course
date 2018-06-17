package com.soa;

import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import com.soa.util.CryptoUtil;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@Data
@ManagedBean
@RequestScoped
public class ChangePassBean {

    @EJB
    private AccessBean accessBean;

    @EJB
    private DataAccessService dataService;

    private UIInput newPasswordUiInput;

    private UIInput repeatPasswordUiInput;

    private String newPassword;

    private String repeatPassword;

    public void submit() {
        UserData user = accessBean.getCurrentUser();
        user.setPassword(CryptoUtil.crypt(newPassword));
        dataService.update(user);
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String newPassword = (String) newPasswordUiInput.getValue();
        String repeatPassword = (String) o;
        if (!newPassword.equals(repeatPassword)) {
            throw new ValidatorException(new FacesMessage("Passwords does not match."));
        }
        System.out.println();
    }
}
