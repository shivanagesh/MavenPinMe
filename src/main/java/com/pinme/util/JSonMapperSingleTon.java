package com.pinme.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
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
