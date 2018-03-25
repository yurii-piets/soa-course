package com.soa.beer.servlet;

import com.soa.beer.model.ExpertBean;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("choose.do")
public class ChooseServlet extends HttpServlet {

    @Inject
    private ExpertBean expert;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String beerColor = request.getParameter("kolor");
        List<String> beersByType = expert.getBeersByType(beerColor);
        request.setAttribute("marki", beersByType);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/jsp/wynik.jsp");
        view.forward(request, response);
    }
}

