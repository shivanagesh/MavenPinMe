package com.pinme.controllers;

import java.util.List;

import com.pinme.dao.EventCategoryDao;
import com.pinme.model.EventCategory;


/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:06:59 PM
 * Modified by Divya for fetching data according to category name
 * fileUserController.java
 */
public class CategoryController {

	private static CategoryController instance = null;
	private EventCategoryDao category;
	/**
	 * 
	 */
	public CategoryController() {
		// TODO Auto-generated constructor stub
		category =  new EventCategoryDao();
	}

	public static CategoryController getInstance() {
		if (instance == null) {
			instance = new CategoryController();
		}
		return instance;
	}
	
	public List<EventCategory> getCatgories(){
		return category.getCatgories();
	}
	
	public EventCategory getCategory(int  id){
		return category.getCategory(id);
	}
	
	public int addtEvent(EventCategory ev){
		return category.addEventCategory(ev);
	}
	
//	public List<EventCategory> getEventCategoryByName(){
//		return category.getCatgories();
//	}
	
	


}
