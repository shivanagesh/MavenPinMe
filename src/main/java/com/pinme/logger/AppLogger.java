package com.pinme.logger;

import java.util.logging.Level;

public class AppLogger {
	private static LoggerImple appLogger = new LoggerImple();
	public static java.util.logging.Logger logger = appLogger.getLogger();
//	public static void main(String[]  args){
//		logger.log(Level.INFO,"Hey how are you");
//	}
}
