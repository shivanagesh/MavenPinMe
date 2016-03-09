package com.pinme.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Event;


/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 */
public class EventDao {
	public static List<Event>	events = new ArrayList<Event>();
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public EventDao() {
	
	}

	public int addEvent(Event event) {
		event.setId(uniqueId.incrementAndGet());
		events.add(event);
		return event.getId();
	}

	public void removeEvent(int id) {
		for (Event event : events) {
			if (event.getId() == (id)) {
				events.remove(event);
				return;
			}

		}

	}
	
	public Event getEvent(int id) {
		for (Event event : events) {
			if (event.getId() == (id)) {
				return event;
			}

		}
		return null;

	}
	
	public List<Event> getEvents(){
		return events;
	}
	
	public List<Event> getUserEvents(int userId){
		List<Event> userEvents = new ArrayList<Event>();
		for (Event event : events) {
			if(event.getUserId() ==  userId){
				userEvents.add(event);
			}
		}
		return userEvents;
	}
	
	public List<Event> getEventsByCategory(int categoryId){
		List<Event> categorEvents = new ArrayList<Event>();
		for (Event event : events) {
			if(event.getCategoryId() ==  categoryId){
				categorEvents.add(event);
			}
		}
		return categorEvents;
	}
	
	
	public void updateEvent(int eventId, Event updateEvent){
		
		for (Event event : events) {
			if(event.getId() ==  eventId){
				if(updateEvent.getName() != null){
					event.setName(updateEvent.getName());
				}
				if(updateEvent.getStartDateTime() != null){
					event.setStartDateTime(updateEvent.getStartDateTime());
				}
				if(updateEvent.getEndDateTime() !=null){
					event.setEndDateTime(updateEvent.getEndDateTime());
				}
				if(updateEvent.getDescription() !=null){
					event.setDescription(updateEvent.getDescription());
				}
				if(updateEvent.getTokenLimit() != -1){
					event.setTokenLimit(updateEvent.getTokenLimit());
				}
				
				if(updateEvent.isTokenized()){
					event.setTokenized(updateEvent.isTokenized());
				}
				
			}
		}
		
	}
	
	

}
