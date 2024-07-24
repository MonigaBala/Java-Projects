/**
 * Package contains helper class that supports the queries.
 */
package com.onlinebookapp.util;

/**
 * Helper class Queries which has all the SQL Queries in the Standard form.
 * 
 * @author MonigaBalasubramanian
 */
public class Queries {

	/**
	 * static final variable String SELECT_QUERY that can be changed so that in the
	 * implementation code the query need not be changed.
	 */
	public static final String SELECT_QUERY = "SELECT * FROM onlinebookapp";

	/**
	 * static final variable String INSERT_QUERY that can be changed so that in the
	 * implementation code the query need not be changed.
	 */
	public static final String INSERT_QUERY = "INSERT INTO onlinebookapp VALUES(?,?,?,?,?); ";

	/**
	 * static final variable String DELETE_QUERY that can be changed so that in the
	 * implementation code the query need not be changed.
	 */
	public static final String DELETE_QUERY = "DELETE FROM onlinebookapp WHERE bookId = ?";

	/**
	 * static final variable String UPDATE_QUERY that can be changed so that in the
	 * implementation code the query need not be changed.
	 */
	public static final String UPDATE_QUERY = "DELETE FROM onlinebookapp WHERE bookId = ?";

	/**
	 * static final variable String SELECT_BY_ID that can be changed so that in the
	 * implementation code the query need not be changed.
	 */
	public static final String SELECT_BY_ID = "SELECT * FROM onlinebookapp WHERE bookId=?;";

	/**
	 * static final variable String SELECT_BY_AUTHOR that can be changed so that in
	 * the implementation code the query need not be changed.
	 */
	public static final String SELECT_BY_AUTHOR = "SELECT * FROM onlinebookapp WHERE author =?;";

	/**
	 * static final variable String SELECT_BY_CATEGORY that can be changed so that
	 * in the implementation code the query need not be changed.
	 */
	public static final String SELECT_BY_CATEGORY = "SELECT * FROM onlinebookapp WHERE category=?;";

	/**
	 * static final variable String SELECT_BY_PRICE that can be changed so that in
	 * the implementation code the query need not be changed.
	 */
	public static final String SELECT_BY_PRICE = "SELECT * FROM onlinebookapp WHERE price=?;";
}
