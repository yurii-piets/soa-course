package com.soa.zad3.sevlet;

import com.soa.zad3.bean.NumberBean;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zad3_rand")
public class RadndomizerServlet extends HttpServlet {

    private static final String RANDOMIZER_VIEW = "WEB-INF/view/zad3/jsp/Randomizer.jsp";

    @Inject
    private NumberBean numberBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(RANDOMIZER_VIEW);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        if(number == null || number.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int compare = numberBean.compare(Integer.valueOf(number));
        request.setAttribute("compare", compare);
        request.setAttribute("guess", numberBean.getGuess());
        request.setAttribute("number", number);
//        response.sendRedirect("/lab3/zad3_rand");
        doGet(request, response);
    }
}
