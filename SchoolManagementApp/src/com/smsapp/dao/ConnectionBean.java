package com.smsapp.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A utility class for managing database connections in the Online Book
 * Application.
 * <p>
 * This class provides static methods for establishing and closing JDBC
 * connections to the database. It uses a properties file to load connection
 * parameters and manages the connection lifecycle.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class ConnectionBean {

	/**
	 * The JDBC connection object. This field is used to store the current
	 * connection to the database.
	 */
	static Connection connection;

	/**
	 * Establishes a connection to the database using parameters specified in a
	 * properties file.
	 * <p>
	 * This method reads the database connection properties from the
	 * {@code jdbc.properties} file, which includes the database URL, username, and
	 * password. It then attempts to load the JDBC driver and establish a connection
	 * to the database using the provided parameters.
	 * </p>
	 * 
	 * @return the {@code Connection} object representing the established connection
	 *         to the database. If the connection cannot be established,
	 *         {@code null} is returned.
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
	 * Closes the current database connection if it is not {@code null}.
	 * <p>
	 * This method checks if the {@code connection} field is not {@code null} and,
	 * if so, closes the connection to free up resources. Any {@code SQLException}
	 * that occurs during the closing process is caught and printed.
	 * </p>
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
