package com.pinme.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pinme.controllers.EventController;
import com.pinme.dao.AddressDao;
import com.pinme.dao.EventCategoryDao;
import com.pinme.model.Address;
import com.pinme.model.Event;
import com.pinme.util.EventUtil;
import com.pinme.util.JSonMapperSingleTon;
import com.pinme.util.MySqlUtil;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
           }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchelem = request.getParameter("searchelement");
		List<com.pinme.model.Event> SearchEvents = EventController.getInstance().getSearchEvents(searchelem);
        response.setContentType("text/json");
        response.getWriter().write(EventUtil.populateJsonFromEvents(SearchEvents));	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession userSession = request.getSession(true);
		 doGet(request,response);
	}
	

}
