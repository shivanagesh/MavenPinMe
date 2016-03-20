package com.pinme.dao;

/**
 *
 */

import java.sql.*;

public abstract class DBConnect {

	// Declare varibles for driver,username,password and connection url
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/pinme";
//   private static final String DB_CONNECTION = "jdbc:mysql://localhost:8889/PinMe" ;
	private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
//	private static final String DB_PASSWORD = "test1234";
	public static Connection dbConnection = null;
	public Statement stmt;
	public ResultSet rslt;

	// Locate the JDBC driver and create database connection with given
	// credentials
	public static Connection getDBConnection() {

		if (dbConnection == null) {
			// Getting mySQL JDBC driver
			try {

				Class.forName(DB_DRIVER);

			} catch (ClassNotFoundException e) {

				System.out.println(e.getMessage());

			}

			// Creating connection and return the connection caller function
			try {

				dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
//				dbConnection=DriverManager.getConnection(DB_CONNECTION);
				return dbConnection;

			} catch (SQLException e) {

				System.out.println(e.getMessage());

			}
		}

		return dbConnection;

	} // End of Connection Method

}// End of DBConnect Class
