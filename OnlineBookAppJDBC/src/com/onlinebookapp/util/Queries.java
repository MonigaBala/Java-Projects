package com.onlinebookapp.util;

/**
 * Helper class Queries which has all the SQL Queries in the Standard form.
 * 
 * @author MonigaBalasubramanian
 */
public class Queries {

	public static final String SELECT_QUERY = "SELECT * FROM onlinebookapp";

	public static final String INSERT_QUERY = "INSERT INTO onlinebookapp VALUES(?,?,?,?,?); ";

	public static final String DELETE_QUERY = "DELETE FROM onlinebookapp WHERE bookId = ?";

	public static final String UPDATE_QUERY = "DELETE FROM onlinebookapp WHERE bookId = ?";

	public static final String SELECT_BY_ID = "SELECT * FROM onlinebookapp WHERE bookId=?;";

	public static final String SELECT_BY_AUTHOR = "SELECT * FROM onlinebookapp WHERE author =?;";

	public static final String SELECT_BY_CATEGORY = "SELECT * FROM onlinebookapp WHERE category=?;";

	public static final String SELECT_BY_PRICE = "SELECT * FROM onlinebookapp WHERE price=?;";
}
