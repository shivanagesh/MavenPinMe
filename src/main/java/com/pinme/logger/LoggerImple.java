/**
 * 
 */
package com.pinme.logger;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.*;

public class LoggerImple {

	public final static Logger logger = Logger.getLogger(LoggerImple.class.getName());
	public static LogFormatter logformater;

	public LoggerImple() {
		initLogger();
	}

	/**
	 * This method initialize default parameters and objects for logger class
	 */
	public void initLogger() {
		try {
			java.util.logging.Logger rootLogger = java.util.logging.Logger.getLogger("");
			rootLogger.setUseParentHandlers(false);
			Handler csvFileHandler = new FileHandler("pinme.csv", 100000, 1, true);
			logformater = new LogFormatter();
			rootLogger.addHandler(csvFileHandler);
			csvFileHandler.setFormatter(logformater);
			logger.setLevel(Level.ALL);
		} catch (IOException ie) {
			System.out.println("Logger initialization failed");
			ie.printStackTrace();
		}
	}

	
	public java.util.logging.Logger getLogger() {
		System.out.println(logger);
		return logger;
	}

}
