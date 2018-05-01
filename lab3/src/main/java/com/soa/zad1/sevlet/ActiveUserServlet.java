package com.soa.zad1.sevlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("zad1_list")
public class ActiveUserServlet extends HttpServlet {

    private static final String USER_LIST_VIEW = "WEB-INF/view/zad1/jsp/list.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(USER_LIST_VIEW);
        view.forward(request, response);
    }
}
