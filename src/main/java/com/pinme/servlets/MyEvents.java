package com.pinme.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pinme.controllers.EventController;
import com.pinme.util.EventUtil;

/**
 * Servlet implementation class MyEvents
 */
@WebServlet("/MyEvents")
public class MyEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyEvents() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int userId = Integer.parseInt(request.getParameter("UserId"));
			List<com.pinme.model.Event> userEvents = EventController.getInstance().getEventsByUserId(userId);
			response.setContentType("text/json");
			response.getWriter().write(EventUtil.populateJsonFromEvents(EventUtil.filterNonExpiredEvents(userEvents)));
		} catch (Exception e) {
			response.getWriter().write("[{'Status':'Fail'}]");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * Servlet method responding to HTTP DELETE methods calls.
	 *
	 * @param request
	 *            HTTP request.
	 * @param response
	 *            HTTP response.
	 */
	@Override
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		try {
			System.out.println(request.getParameter("EventId"));
	        int eventId = Integer.parseInt(request.getParameter("EventId"));
	        int result = EventController.getInstance().removeEvent(eventId);
	        response.setContentType("text/json");
	        if(result > 0){
	            response.getWriter().write("{\"Status\":\"Success\"}");
	        } else{
	            response.getWriter().write("[{'Status':'Fail'}]");
	        }
	        }
	        catch(Exception e ){
	        	e.printStackTrace();
	        	response.getWriter().write("[{'Status':'Fail'}]");
	        }
		
	}

}
