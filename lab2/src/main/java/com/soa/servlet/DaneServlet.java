package com.soa.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dane")
public class DaneServlet extends HttpServlet {

    private static final String NAME_PARAMETER = "name";
    private static final String AGE_PARAMETER = "age";
    private static final String WOMAN_NAME_PATTERN = ".*a";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter(NAME_PARAMETER);
        if (name.matches(WOMAN_NAME_PATTERN)) {
            Integer age = Integer.valueOf(request.getParameter(AGE_PARAMETER));
            if (age >= 18) {
                writer.append("Jest pełnoletnia");
            } else {
                writer.append("Nie jest pełnoletnia");
            }
        } else {
            writer.append("Nie jest kobietą");
        }

        writer.flush();
    }
}
