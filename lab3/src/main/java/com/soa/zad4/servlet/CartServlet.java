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

@WebServlet("/zad4_cart")
public class CartServlet extends HttpServlet {

	private static final String CART_VIEW = "WEB-INF/view/zad4/jsp/Cart.jsp";

	@Inject
	private Cart cart;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cart", cart.getProducts());
		RequestDispatcher view = request.getRequestDispatcher(CART_VIEW);
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
