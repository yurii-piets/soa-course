package com.soa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

import static com.soa.auth.AuthorizationFilter.MESSAGES_SESSION_ATTRIBUTE;

@ManagedBean
@SessionScoped
public class MessageBean {

    @SuppressWarnings("unchecked")
    public List<String> messages() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        if (session != null) {
            return (List<String>) session.getAttribute(MESSAGES_SESSION_ATTRIBUTE);
        }
        return Collections.emptyList();
    }
}
