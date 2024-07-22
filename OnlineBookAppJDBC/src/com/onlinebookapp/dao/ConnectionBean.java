package com.onlinebookapp.dao;

/**
 *  ConnectionBean Class which has two static methods for establishing and closing connections. 
 * openConnection() and closeConnection() .
 * 
 * @author MonigaBalasubramanian
 */
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionBean {

	static Connection connection;

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
