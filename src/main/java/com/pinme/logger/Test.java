package com.pinme.logger;

import java.util.logging.Level;

import org.apache.log4j.Logger;

/**
 * @author Shivanagesh Chandra Mar 18, 2016 9:25:00 PM
 * fileTest.java
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(Test.class);
		logger.warn("This is warn ");
	}

}
