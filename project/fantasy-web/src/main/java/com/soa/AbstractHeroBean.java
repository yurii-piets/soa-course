package com.soa;

import lombok.Data;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Data
public abstract class AbstractHeroBean {

    public abstract void modify() throws IOException;

    public abstract void delete() throws IOException;

    protected void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
}
