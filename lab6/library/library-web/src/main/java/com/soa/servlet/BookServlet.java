package com.soa.servlet;

import com.soa.data.Book;
import com.soa.ejb.BookManager;
import com.soa.jms.BookRegisterService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/library")
public class BookServlet extends HttpServlet {

    private static final String LIBRARY_VIEW = "WEB-INF/view/jsp/Books.jsp";

    @EJB
    private BookManager bookManager;

    @Inject
    private BookRegisterService bookRegisterService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", bookManager.getBooks());
        RequestDispatcher view = request.getRequestDispatcher(LIBRARY_VIEW);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String operation = request.getParameter("operation");
        try {
            switch (operation) {
                case "add":
                    String author = request.getParameter("author");
                    String title = request.getParameter("title");
                    Book book = new Book(isbn, title, author);
                    bookRegisterService.add(book);
                    break;
                case "rent":
                    bookManager.rent(isbn);
                    break;
                case "reserve":
                    bookManager.reserve(isbn);
                    break;
                case "retrieve":
                    bookManager.retrieve(isbn);
                    break;
            }
        } catch (IllegalAccessException e) {
            request.setAttribute("error", e.getMessage());
        }
        doGet(request, response);
    }
}
