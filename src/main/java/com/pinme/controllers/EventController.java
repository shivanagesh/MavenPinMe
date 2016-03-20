package com.pinme.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.pinme.dao.AddressDao;
import com.pinme.dao.EventCategoryDao;
import com.pinme.dao.EventDao;
import com.pinme.dao.TokenDao;
import com.pinme.dao.UserDao;
import com.pinme.mail.Mail;
import com.pinme.model.*;

/**
 *
 */
public class EventController {

	private static EventController instance = null;
	private EventDao eventDao;
	private EventCategoryDao eventCategory;
	private AddressDao address;
	private TokenDao tokendao;
	private UserDao userDao;

	/**
	 * 
	 */
	public EventController() {
		eventDao = new EventDao();
		eventCategory = new EventCategoryDao();
		address = new AddressDao();
		tokendao = new TokenDao();
		userDao = new UserDao();
	}

	public static EventController getInstance() {
		if (instance == null) {
			instance = new EventController();
		}
		return instance;
	}

	public List<EventCategory> getEventCategories() {
		return eventCategory.getCategoriesFromDb();
	}

	public EventCategory getEventCategoryByName(String categoryName) {
		return eventCategory.getEventCategoryByName(categoryName);
	}

	public EventCategory getEventCategoryById(int categoryId) {
		return eventCategory.getEventCategoryById(categoryId);
	}

	public List<Event> getEvents() {
		return eventDao.findAllEventsFromDB();
	}

	public List<Event> getPinnedEvents(int userId) {
		return eventDao.getPinnedEventsByUserId(userId);
	}

	public List<Event> getEventsByUserId(int userId) {
		return eventDao.findEventsByUserId(userId);
	}

    public Event getEventByEventId(int eventId){
        return eventDao.getEvent(eventId);
    }

	public Address getEventAddress(Event event) {
		return address.getAddress(event.getAddressId());
	}

	public int createEvent(Address ad, int categoryId, Event event) {
		try {
			int addressId = address.addAddress(ad);
			event.setAddressId(addressId);
			event.setCategoryId(categoryId);
			return eventDao.addEvent(event);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int updateEvent(Address ad, int categoryId, Event event) {
        int result = -1;
		try {
			address.updateAddress(ad.getId(), ad);
			event.setCategoryId(categoryId);
            result = eventDao.updateEvent(event.getId(), event);
		} catch (Exception e) {
			e.printStackTrace();
            result = -1;
		}
        return result;
	}

	public int pinEvent(int userid, int eventId) {
		int result = -1;
		try {

			result = eventDao.pinEvent(userid, eventId);
			// if(eventDao.getEvent(eventId).isTokenized()){
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String timeStamp = dateFormat.format(date);
			Token t = new Token(eventId, userid, timeStamp);
			int tokenId = tokendao.generateToken(t);
			// System.out.println(userid);
			// User u = userDao.getUser(userid);
			// eventDao.getEvent(eventId).setTokenLimit(eventDao.getEvent(eventId).getTokenLimit()-1);
			// System.out.println(u);
			Mail.sendMail("ch.shivanagesh@gmail.com",
					"Hey there, \n Your token number is " + tokenId + " \n Thanks,\n Pinme", "Your token");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int removeEvent(int id) {
		try {
			Event ev = eventDao.getEvent(id);
			int addId = ev.getAddressId();
			int rvalue = eventDao.removeEvent(id);
			address.removeAddress(addId);
			return rvalue;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}


    public List<Event> getSearchEvents(String event){
        return eventDao.getEventsBySearch(event);
    }
    
    public List<Event> getEventsbyCategory(String event){
        return eventDao.getEventCategories(event);
    }

}
