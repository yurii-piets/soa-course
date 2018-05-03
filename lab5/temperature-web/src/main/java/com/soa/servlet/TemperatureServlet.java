package com.soa.servlet;

import com.soa.ejb.def.Converter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temperature")
public class TemperatureServlet extends HttpServlet {

    private static final String TEMPERATURE_VIEW = "WEB-INF/view/jsp/Temperature.jsp";

    @EJB
    private Converter converter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(TEMPERATURE_VIEW);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temperatureString = request.getParameter("temperature");
        if (temperatureString == null || temperatureString.isEmpty()) {
            request.setAttribute("result", null);
            doGet(request, response);
            return;
        }

        Double temperature = Double.valueOf(temperatureString);
        String direction = request.getParameter("direction");

        Double converted = null;
        if (direction.equals("c2f")) {
            converted = converter.cels2Fahr(temperature);
        } else if (direction.equals("f2c")) {
            converted = converter.fahr2Cels(temperature);
        }
        request.setAttribute("result", converted);
        doGet(request, response);
    }
}
