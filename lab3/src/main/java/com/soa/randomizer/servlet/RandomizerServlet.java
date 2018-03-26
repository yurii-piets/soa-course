package com.soa.randomizer.servlet;

import com.soa.randomizer.model.RandomizerBean;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/randomizer")
public class RandomizerServlet extends HttpServlet {

    @Inject
    private RandomizerBean randomizer;

    private Integer number;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        randomizer.generate();
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/jsp/randomizer.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/view/jsp/randomizer.jsp");
        view.forward(request, response);
    }
}
