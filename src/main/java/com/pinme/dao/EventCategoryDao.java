package com.pinme.dao;

import java.util.ArrayList;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.EventCategory;


/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 */
public class EventCategoryDao {
	public static List<EventCategory> eventCategories = new ArrayList<EventCategory>();
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public EventCategoryDao() {
		
	}

	public int addEventCategory(EventCategory eventCategory) {
		eventCategory.setId(uniqueId.incrementAndGet());
		eventCategories.add(eventCategory);
		return eventCategory.getId();
	}

	public void removeEventCategory(int id) {
		for (EventCategory eventCatgoey : eventCategories) {
			if (eventCatgoey.getId() == (id)) {
				eventCategories.remove(eventCatgoey);
				return;
			}

		}

	}
	

	public EventCategory getCategory(int eventCategoryId) {
		for (EventCategory eventCatgoey : eventCategories) {
			if (eventCatgoey.getId() == (eventCategoryId)) {
				return eventCatgoey;
			}

		}
		return null;
	}

	public void updateCategory(int eventCategoryId, EventCategory updateEventCategory) {

		for (EventCategory eventCatgoey : eventCategories) {
			if (eventCatgoey.getId() == (eventCategoryId)) {
				eventCatgoey = updateEventCategory;
			}

		}

	}
	
	public List<EventCategory> getCatgories(){
		 return eventCategories; 
	} 

}
