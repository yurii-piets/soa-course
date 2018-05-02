package com.soa.zad4.servlet;

import com.soa.zad4.bean.Cart;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/zad4_parts")
public class PartServlet extends HttpServlet {

	private static final String PARTS_VIEW = "WEB-INF/view/zad4/jsp/Parts.jsp";

	@Inject
	private Cart cart;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(PARTS_VIEW);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long partId = Long.valueOf(request.getParameter("id"));
		cart.add(partId);
		doGet(request, response);
	}
}
