package com.soa.zad1.sevlet;

import com.soa.zad1.bean.UserBean;
import com.soa.zad1.domain.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.soa.zad1.bean.UserBean.LOGIN_ATTRIBUTE_NAME;
import static com.soa.zad1.bean.UserBean.PASSWORD_ATTRIBUTE_NAME;

@WebServlet("/zad1_login")
public class LoginServlet extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(LOGIN_ATTRIBUTE_NAME);
        String password = request.getParameter(PASSWORD_ATTRIBUTE_NAME);

        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN_ATTRIBUTE_NAME, login);
        session.setAttribute(PASSWORD_ATTRIBUTE_NAME, DigestUtils.md5Hex(password));

        userBean.addUser(User.builder()
                .login(login)
                .password(password)
                .build());

        response.sendRedirect("/lab3/zad1_welcome");
    }
}
