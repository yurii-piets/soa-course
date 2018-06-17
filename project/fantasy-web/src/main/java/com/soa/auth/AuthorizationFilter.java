package com.soa.auth;

import com.soa.session.SessionManagerBean;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.soa.session.HttpSessionListenerImpl.LOGIN_SESSION_PARAMETER;

public class AuthorizationFilter implements Filter {

    @EJB
    private SessionManagerBean sessionManagerBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            if (httpServletRequest.getHeader("User-Agent").contains("Firefox")) {
                if (response instanceof HttpServletResponse) {
                    ((HttpServletResponse) response).sendError(403);
                    httpServletRequest.logout();
                }
                return;
            }
            String name = httpServletRequest.getUserPrincipal().getName();
            if (sessionManagerBean.isLocked(name, httpServletRequest.getSession())) {
                if (response instanceof HttpServletResponse) {
                    ((HttpServletResponse) response).sendError(423);
                    httpServletRequest.logout();
                }
                return;
            } else {
                httpServletRequest.getSession(true).setAttribute(LOGIN_SESSION_PARAMETER, name);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
