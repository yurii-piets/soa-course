package com.soa.servlet.book;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private static final String SUBMIT_FORM =
            "<form action=\"http://127.0.0.1:8080/lab2/books\" method=\"post\">\n" +
                    "   Your Name: <input type=\"name\" name=\"name\"><br>\n" +
                    "   Your Email: <input type=\"email\" name=\"email\"><br>\n" +
                    "   Comment: <input type=\"comment\" name=\"comment\"><br>\n" +
                    "   <input type=\"submit\" value=\"Submit\">\n" +
                    "</form>";

    private Map<String, List<Contact>> contacts = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Object login = req.getSession().getAttribute("login");
        if (login == null) {
            resp.sendRedirect("/lab2/login");
            return;
        }

        writer.write("<html>\n" +
                "            <head><title>Login Page</title></head>\n" +
                "            <body bgcolor = \"#f0f0f0\">\n");
        writer.write(SUBMIT_FORM);

        if (contacts.get(login.toString()) == null || contacts.get(login.toString()).isEmpty()) {
            return;
        }

        for (Contact contact : contacts.get(login.toString())) {
            writer.write("<h1>" + contact.getName() + "</h1>" + "\t(" + contact.getEmail() + ")");
            if (!StringUtils.isEmpty(contact.getComment())) {
                writer.write(contact.getComment());
            }
        }
        writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String name = parameterMap.get("name")[0];
        String email = parameterMap.get("email")[0];
        String comment = parameterMap.get("comment") != null ? parameterMap.get("comment")[0] : null;

        Contact contact = Contact.builder()
                .name(name)
                .email(email)
                .comment(comment)
                .build();

        Object login = req.getSession().getAttribute("login");
        if (login == null) {
            resp.sendRedirect("/lab2/login");
            return;
        }

        List<Contact> currentContacts = contacts.getOrDefault(login.toString(), new LinkedList<>());
        currentContacts.add(contact);
        contacts.put(login.toString(), currentContacts);

        resp.sendRedirect("/lab2/books");
    }
}
