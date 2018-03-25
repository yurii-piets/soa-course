package com.soa.beer.servlet;

import com.soa.beer.model.ExpertBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("choose.do")
public class ChooseServlet extends HttpServlet {

    @Inject
    private ExpertBean expert;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Porada piwna<br/>");
        String beerColor = request.getParameter("kolor");
        out.println("<br/>Wybor kolor piwa: " + beerColor);
        out.println("<ul>");
        expert.getBeersByType(beerColor)
                .stream()
                .map(b -> "<li>" + b + "</li>")
                .forEach(out::println);
        out.println("</ul>");
    }
}
