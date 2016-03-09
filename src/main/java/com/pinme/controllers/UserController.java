package com.pinme.controllers;

import com.pinme.dao.UserDao;
import com.pinme.model.User;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:06:59 PM
 * fileUserController.java
 */
public class UserController {

	private static UserController instance = null;
	private UserDao user;
	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
		user =  new UserDao();
		loadData();
	}
	public void loadData(){
		User us = new User("Shivangesh", "Chandra", "123456", "ch.shivanagesh@gmail.com", "848-333-1895");
		addUser(us);
	}

	public static UserController getInstance() {
		if (instance == null) {
			instance = new UserController();
		}
		return instance;
	}
	
	public boolean authenticate(String email,String password){
		if(user.getUserByEmail(email, password)	!= null){
			return true;
		}else{
			return false;
		}
	}
	
	public User getUser(String email,String password){
		return user.getUserByEmail(email, password);
	}
	
	public int addUser(User newUser){
		return user.addUser(newUser);
	}
	
	
	


}
