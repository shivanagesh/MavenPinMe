/**
 * 
 */
package com.pinme.logger;

import java.io.IOException;

import java.util.logging.*;

/**
 * <h1>Garden Logger</h1>
 * <p> Which contains extension for logging functionality and file handler for log <p> 
 * @author Shivanagesh Chandra Feb 14, 2016 Logger.java
 */

public class Logger {

	public final static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());
	public static LogFormatter logformater;

	public Logger() {
		initLogger();
	}

	/**
	 * This method initialize default parameters and objects for logger class
	 */
	private void initLogger() {
		try {
			java.util.logging.Logger rootLogger = java.util.logging.Logger.getLogger("");
			rootLogger.setUseParentHandlers(false);
			Handler csvFileHandler = new FileHandler("logger/log.csv", 100000, 1, true);
			logformater = new LogFormatter();
			rootLogger.addHandler(csvFileHandler);
			csvFileHandler.setFormatter(logformater);
			logger.setLevel(Level.ALL);
		} catch (IOException ie) {
			System.out.println("Logger initialization failed");
			ie.printStackTrace();
		}
	}

	public void log(LogRecord record) {
		logger.log(record);
	}

	

	

}
