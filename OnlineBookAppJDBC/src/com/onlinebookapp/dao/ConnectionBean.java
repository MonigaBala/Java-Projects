/**
 *  Provides the Data Access Object (DAO) classes for the Online Book Application.
 *  This package includes the DAO classes which are responsible for interacting with
 * the database to perform CRUD (Create, Read, Update, Delete) operations. These classes
 * serve as an interface between the application and the database, ensuring a separation
 * of concerns and promoting a clean architecture.
 * 
 *  @author MonigaBalasubramanian
 */
package com.onlinebookapp.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ConnectionBean Class which has two static methods for establishing and
 * closing connections. openConnection() and closeConnection() .
 * 
 * @author MonigaBalasubramanian
 */

public class ConnectionBean {

	/**
	 * Static method connection of type Connection to establish connection and close
	 * connection.
	 */
	static Connection connection;

	/**
	 * static Connection openConnection() method establishes connection from a JDBC
	 * Driver and loads its properties.
	 * 
	 * @return connection
	 */
	public static Connection openConnection() {
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = (String) properties.getProperty("driver");
		String username = (String) properties.getProperty("username");
		String password = (String) properties.getProperty("password");
		connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * static void closeConnection() method closes the connection if it's not null.
	 */
	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
