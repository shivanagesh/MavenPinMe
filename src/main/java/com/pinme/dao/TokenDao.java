package com.pinme.dao;

import java.util.ArrayList;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pinme.model.EventCategory;
import com.pinme.model.Token;


/**
 *
 */
public class TokenDao {
	public static List<Token> tokens = new ArrayList<Token>();
	private static AtomicInteger uniqueId = new AtomicInteger();

	/**
	 * 
	 */
	public TokenDao() {
		
	}

	public int generateToken(Token token) {
		token.setTokenId((uniqueId.incrementAndGet()));
		tokens.add(token);
		return token.getTokenId();
	}

	public int getTokenCount(int eventId){
		int count = 0;
		for (Token token : tokens) {
			if(token.getEventId() == eventId){
				count++;
			}
		}
		return count;
	}
	
	public List<Token> getUseToken(int userId){
		List<Token> userToken = new ArrayList<Token>();
		for (Token token : tokens) {
			if(token.getUserID() == userId){
				userToken.add(token);
			}
		}
		return userToken;
	}
	
	

}
