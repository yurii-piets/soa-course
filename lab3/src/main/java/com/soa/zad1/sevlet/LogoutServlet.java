package com.soa.zad1.sevlet;

import com.soa.zad1.bean.UserBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.soa.zad1.bean.UserBean.LOGIN_ATTRIBUTE_NAME;

@WebServlet("/zad1_logout")
public class LogoutServlet extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session == null) {
            return;
        }
        userBean.removeUserByLogin((String) session.getAttribute(LOGIN_ATTRIBUTE_NAME));
        session.invalidate();

        response.sendRedirect("/lab3/zad1_welcome");
    }
}
