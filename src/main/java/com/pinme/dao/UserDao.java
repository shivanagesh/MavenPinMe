package com.pinme.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.User;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 11:32:31 PM fileUserDao.java
 */
public class UserDao {
	public static List<User> users = new ArrayList<User>();;
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public UserDao() {
		
	}

	public int addUser(User user) {
		user.setId(uniqueId.incrementAndGet());
		users.add(user);
		return user.getId();
	}

	public User getUser(int id) {
		System.out.println(users);
		for (User user : users) {
			System.out.println(user.getId());
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	public User getUserByEmail(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public User getUserByUserName(String userName, String password) {
		for (User user : users) {
			if (user.getUsername().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public void removeUser(String emailOrUserName, String password) {
		for (User user : users) {
			if (user.getEmail().equals(emailOrUserName) && user.getPassword().equals(password)) {
				users.remove(user);
				return;
			}
			if (user.getUsername().equals(emailOrUserName) && user.getPassword().equals(password)) {
				users.remove(user);
				return;
			}
		}
	
	}
	
	public void updateUser(int userId,User updateUser){
		for (User user : users) {
			if (user.getId() == (userId) ) {
			    user = updateUser;
			}
			
		}
	}

}
