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
import com.pinme.controllers.UserController;
import com.pinme.model.User;
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("userName");
		String password=request.getParameter("Password");
		
		response.setContentType("text/html");
		request.getRequestDispatcher("home.html").forward(request, response);
		
//		 response.setContentType("application/json");
//	     PrintWriter out = response.getWriter();
//	     out.println(username);
//	     out.println(password);
//	     
//	     if(UserController.getInstance().authenticate(username, password))
//	     {
//		String jsonInString = JSonMapperSingleTon.getInstance().writeValueAsString((UserController.getInstance().getUser(username, password)));
//		System.out.println(jsonInString);
//		out.println(jsonInString);
//	    	 }
//		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}
}
