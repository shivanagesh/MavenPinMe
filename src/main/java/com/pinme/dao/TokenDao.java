package com.pinme.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.Event;
import com.pinme.model.EventCategory;
import com.pinme.model.Token;
import com.pinme.model.User;


/**
 *
 */
public class TokenDao extends DBConnect{
	public static List<Token> tokens = new ArrayList<Token>();
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public TokenDao() {
		
	}

	public int generateToken(Token token) {
		String sql = "INSERT INTO token (user_id, event_id, datetime) VALUES (?, ?, ?);";
		PreparedStatement tokenInsertStatement = null;
		try {
			tokenInsertStatement = dbConnection.prepareStatement(sql);
			tokenInsertStatement.setInt(1, token.getUserID());
			tokenInsertStatement.setInt(2, token.getEventId());
			tokenInsertStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			int id = tokenInsertStatement.executeUpdate();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public int getTokenCount(int eventId){
		String sql = "Select id from token where event_id = ?";
		PreparedStatement tokenSelectStatement = null;
		try {
			tokenSelectStatement = dbConnection.prepareStatement(sql);
			tokenSelectStatement.setInt(1, eventId);
			int id = tokenSelectStatement.executeUpdate();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public int getUserToken(int userId, int eventId){
		String sql = "Select id from token where user_id = ?  and event_id = ?";
		PreparedStatement tokenSelectStatement = null;
		try {
			tokenSelectStatement = dbConnection.prepareStatement(sql);
			tokenSelectStatement.setInt(1, userId);
			tokenSelectStatement.setInt(2, eventId);
			ResultSet rs = tokenSelectStatement.executeQuery();

			while (rs.next()) {
				return Integer.parseInt(rs.getString("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Integer> getUserAllToken(int userId){
		String sql = "Select id from token where user_id = ?  and event_id = ?";
		PreparedStatement tokenSelectStatement = null;
		List<Integer> eventIds = new ArrayList<Integer>();
		try {
			tokenSelectStatement = dbConnection.prepareStatement(sql);
			tokenSelectStatement.setInt(1, userId);
			
			ResultSet rs = tokenSelectStatement.executeQuery();

			while (rs.next()) {
				eventIds.add(Integer.parseInt(rs.getString("event_id")));
			}
			return eventIds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
