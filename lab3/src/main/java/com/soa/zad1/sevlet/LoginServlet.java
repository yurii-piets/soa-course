package com.soa.zad1.sevlet;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/zad1_login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_ATTRIBUTE_NAME = "login";
    private static final String PASSWORD_ATTRIBUTE_NAME = "password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_ATTRIBUTE_NAME);
        String password = request.getParameter(PASSWORD_ATTRIBUTE_NAME);

        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN_ATTRIBUTE_NAME, login);
        session.setAttribute(PASSWORD_ATTRIBUTE_NAME, DigestUtils.md5Hex(password));

        response.sendRedirect("/lab3/zad1_welcome");
    }
}
