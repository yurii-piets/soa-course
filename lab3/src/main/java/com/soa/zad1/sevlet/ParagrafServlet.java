package com.soa.zad1.sevlet;

import com.soa.zad1.CurrencyUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zad1_parag")
public class ParagrafServlet extends HttpServlet {

    private static final String PARAGRAF_VIEW = "WEB-INF/view/zad1/jsp/paragraph.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrencyUtil.covert(1D, "usd","pln");
        RequestDispatcher view = request.getRequestDispatcher(PARAGRAF_VIEW);
        view.forward(request, response);
    }
}
