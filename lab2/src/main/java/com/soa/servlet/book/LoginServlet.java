package com.soa.servlet.book;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_PAGE = "<html>\n" +
            "<head><title>Login Page</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
            "<form action=\"http://127.0.0.1:8080/lab2/login\" method=\"post\">\n" +
            "   Login: <input type=\"text\" name=\"login\"><br>\n" +
            "   Password: <input type=\"password\">\n" +
            "   <input type=\"submit\" value=\"Submit\">\n" +
            "</form>" +
            "</body>" +
            "</html>";
    private final String DOC_TYPE = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";

    @Inject
    private AuthService authService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println(DOC_TYPE + LOGIN_PAGE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Map<String, String[]> parameterMap = req.getParameterMap();
        String[] loginArray = parameterMap.get("login");
        String[] passwordArray = parameterMap.get("login");

        if (loginArray.length != 1 && passwordArray.length != 1) {
            writer.println("Wrong number of parameters.");
            return;
        }

        String login = loginArray[0];
        String password = passwordArray[0];

        if (!authService.checkLogin(login)) {
            writer.println("Wrong email.");
            return;
        }

        if (!authService.checkCredentials(login, password)) {
            writer.println("Wrong email/password.");
            return;
        }

        req.getSession().setAttribute("login", login);
        resp.sendRedirect("/lab2/book");
    }
}
