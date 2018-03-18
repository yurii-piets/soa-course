package com.soa.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/number")
public class NumbersServlet extends HttpServlet {

    //"zadanie przeczytać of jsp"

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String[] numbers = request.getParameterValues("number");
        if (numbers == null || numbers.length != 5) {
            writer.append("Wrong number of parameters.");
            return;
        }

        Double average = Arrays.stream(numbers)
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0);

        writer.append(average.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            String s = request.getParameterMap().values().stream()
                    .flatMap(Arrays::stream)
                    .mapToDouble(Double::valueOf)
                    .boxed()
                    .sorted(Double::compareTo)
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));

            writer.append(s);
        } catch (NumberFormatException e) {
            writer.append("Wrong number formatting");
        }
    }
}
