package com.pinme.sevlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinme.controllers.Test;
import com.pinme.controllers.UserController;
import com.pinme.util.JSonMapperSingleTon;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		
		super();
		Test.loadData();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("index.html").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String username = request.getParameter("userEmail");
		String password = request.getParameter("Password");

		response.setContentType("application/json");

//		PrintWriter out = response.getWriter();
//		out.println(username);
//		out.println(password);

		if (UserController.getInstance().authenticate(username, password)) {
			response.setContentType("text/html");
			request.getRequestDispatcher("home.html").forward(request, response);
		}else{
			response.setContentType("text/html");
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}
}
