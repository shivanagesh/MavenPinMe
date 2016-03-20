package com.pinme.servlets;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.pinme.controllers.EventController;
import com.pinme.logger.AppLogger;

/**
 * Servlet implementation class CheckIsPined
 */
@WebServlet("/CheckIsPined")
public class CheckIsPined extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIsPined() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 JSONObject eventObj = new JSONObject();
		try {
	     	int userId = Integer.parseInt(request.getParameter("UserId"));
	        int eventId = Integer.parseInt(request.getParameter("EventId"));
	        int result = EventController.getInstance().isUserAlreadyPined(userId, eventId);
	        response.setContentType("text/json");
	       
	        eventObj.put("Satus", "success");
	        
	        if(result > 0){
	            response.getWriter().write(eventObj.toJSONString());
	        } else{
	            response.getWriter().write(eventObj.toJSONString());
	    	        }
	        return;
	        }
	        catch(Exception e ){
	        	e.printStackTrace();
	        	eventObj.put("Satus", "fail");
	        	response.getWriter().write(eventObj.toJSONString());
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
