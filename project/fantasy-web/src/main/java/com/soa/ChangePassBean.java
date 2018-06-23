package com.soa;

import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import com.soa.util.CryptoUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@Data
@ManagedBean
@RequestScoped
public class ChangePassBean extends AbstractManagedBean {

    @EJB
    private AccessBean accessBean;

    @EJB
    private DataAccessService dataService;

    private UIInput newPasswordUiInput;

    private UIInput repeatPasswordUiInput;

    private String newPassword;

    private String repeatPassword;

    private String userLogin;

    public void submit() throws IOException {
        UserData user;
        if (userLogin == null || userLogin.isEmpty()) {
            user = accessBean.getCurrentUser();
        } else {
            user = dataService.findUserDataByLogin(userLogin);
        }
        user.setPassword(CryptoUtil.crypt(newPassword));
        dataService.update(user);
        reload();
    }

    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String newPassword = (String) newPasswordUiInput.getValue();
        String repeatPassword = (String) o;
        if (!newPassword.equals(repeatPassword)) {
            throw new ValidatorException(new FacesMessage("Passwords do not match."));
        }
    }
}
