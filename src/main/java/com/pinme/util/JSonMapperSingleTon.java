package com.pinme.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Shivanagesh Chandra Mar 7, 2016 10:52:30 PM
 *         fileJSonMapperSingleTon.java
 */
public class JSonMapperSingleTon {

	private static ObjectMapper instance = null;

	/**
	 * 
	 */
	public JSonMapperSingleTon() {
		// TODO Auto-generated constructor stub
	}

	public static ObjectMapper getInstance() {
		if (instance == null) {
			instance = new ObjectMapper();
		}
		return instance;
	}

}
