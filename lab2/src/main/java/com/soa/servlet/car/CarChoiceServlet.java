package com.soa.servlet.car;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/car")
public class CarChoiceServlet extends HttpServlet {

    @Inject
    private CarChoiceHelper carChoiceHelper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        String carMarks = carChoiceHelper.getCarMarks()
                .stream()
                .map(cm -> "<option value=\"" + cm.toLowerCase() + "\">" + cm + "</option>\n")
                .collect(Collectors.joining("\n"));

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        writer.println(docType);
        writer.println("<html>\n" +
                "<head><title> + title + </title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<form action=\"http://127.0.0.1:8080/lab2/car\" method=\"post\">\n" +
                "   <select name=\"cars\">\n" +
                        carMarks +
                "   </select>\n" +
                "   <br>\n" +
                "   Car name:\n" +
                "   <input type=\"text\" name=\"carName\"><br>\n" +
                "   <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String q = request.getParameterMap().entrySet()
                .stream()
                .map(e -> e.getKey() + ": " + Arrays.stream(e.getValue()).collect(Collectors.joining(", ")))
                .collect(Collectors.joining("\n"));

        writer.println(q);
    }
}
