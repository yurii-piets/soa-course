package com.soa.session;

import javax.ejb.EJB;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerImpl implements HttpSessionListener {

    public static final String LOGIN_SESSION_PARAMETER = "login";

    @EJB
    private SessionManagerBean sessionManagerBean;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionManagerBean.logout((String) se.getSession().getAttribute(LOGIN_SESSION_PARAMETER));
    }
}
