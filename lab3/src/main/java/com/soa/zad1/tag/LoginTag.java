package com.soa.zad1.tag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class LoginTag extends SimpleTagSupport {

    @Getter
    @Setter
    private boolean authenticated;

    private final static String LOGIN_FORM = "<form action=\"/lab3/zad1_login\" method=\"post\">\n" +
            "    Login: <input type=\"text\" name=\"login\"><br>\n" +
            "    Password: <input type=\"password\" name=\"password\"><br>\n" +
            "    <input type=\"submit\" value=\"Login\">\n" +
            "</form>";

    private final static String LOGOUT_FORM = "<form action=\"/lab3/zad1_logout\" method=\"post\">\n" +
            "    <input type=\"submit\" value=\"Logout\">\n" +
            "</form>";

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        if (authenticated) {
            out.write(LOGOUT_FORM);
        } else {
            out.write(LOGIN_FORM);
        }
    }
}
