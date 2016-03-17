package com.pinme.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.pinme.controllers.EventController;
import com.pinme.dao.AddressDao;
import com.pinme.dao.EventCategoryDao;
import com.pinme.model.Address;
import com.pinme.model.Event;
import com.pinme.util.JSonMapperSingleTon;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String searchelem = request.getParameter("searchelement");
		List<Event> list = EventController.getInstance().getEvents();
		JSONArray jsonlist = new JSONArray();
		
		for (Event ev : list) {
			JSONObject object = new JSONObject();
			object.put("Name", ev.getName());
			SimpleDateFormat dateformatter = new SimpleDateFormat("MM-dd-YYY");
			SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm");
			Date date = null;
			Date time = null;
			try {
				date = dateformatter.parse(ev.getStartDateTime());
				time = timeformatter.parse(ev.getStartDateTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			object.put("Date", date);
			object.put("Time", time);
			object.put("Description", ev.getDescription());
			AddressDao addao = new AddressDao();
			Address adrres = addao.getAddress(ev.getAddressId());
			object.put("Location", JSonMapperSingleTon.getInstance().writeValueAsString(adrres));
			EventCategoryDao edao = new EventCategoryDao();
			object.put("category", edao.getCategory(ev.getCategoryId()).getName());
			if(ev.isTokenized()){
				object.put("Limit", ev.getTokenLimit());
			}
			jsonlist.add(JSonMapperSingleTon.getInstance().writeValueAsString(object));	
		}	
		response.getWriter().write(JSonMapperSingleTon.getInstance().writeValueAsString(jsonlist));
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
