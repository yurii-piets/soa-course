package com.soa.zad5.servlet;

import com.google.common.collect.Sets;
import com.soa.zad5.data.FilmData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/zad5_films")
public class FilmServlet extends HttpServlet {

    private static final String FILMS_VIEW = "WEB-INF/view/zad5/jsp/Film.jsp";

    private final Set<FilmData> films = Sets.newHashSet(
            new FilmData("Pluton", "wojenny", 1986, 120_000_000),
            new FilmData("Neptun", "niewojenny", 2002, 50_000_000),
            new FilmData("Pluton 2", "antywojenny", 2020, 70_000_000)
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("films", films);
        RequestDispatcher view = request.getRequestDispatcher(FILMS_VIEW);
        view.forward(request, response);
    }
}
