package com.onlinebookapp.util;

/**
 * A utility class that contains all SQL queries used in the Online Book
 * Application.
 * <p>
 * This class provides standard SQL query strings for common database operations
 * related to the book entity. By centralizing the SQL queries in one place, it
 * simplifies maintenance and makes it easier to manage changes to query strings
 * without altering the implementation code throughout the application.
 * </p>
 * 
 * <p>
 * The queries included in this class are:
 * <ul>
 * <li>{@link #SELECT_QUERY} - Retrieves all records from the onlinebookapp
 * table.</li>
 * <li>{@link #INSERT_QUERY} - Inserts a new record into the onlinebookapp
 * table.</li>
 * <li>{@link #DELETE_QUERY} - Deletes a record from the onlinebookapp table
 * based on the bookId.</li>
 * <li>{@link #UPDATE_QUERY} - Updates a record in the onlinebookapp table based
 * on the bookId.</li>
 * <li>{@link #SELECT_BY_ID} - Retrieves a record from the onlinebookapp table
 * based on the bookId.</li>
 * <li>{@link #SELECT_BY_AUTHOR} - Retrieves records from the onlinebookapp
 * table based on the author.</li>
 * <li>{@link #SELECT_BY_CATEGORY} - Retrieves records from the onlinebookapp
 * table based on the category.</li>
 * <li>{@link #SELECT_BY_PRICE} - Retrieves records from the onlinebookapp table
 * based on the price.</li>
 * </ul>
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class Queries {

	/**
	 * SQL query string to select all records from the {@code onlinebookapp} table.
	 * <p>
	 * This query retrieves all columns for all rows in the table. It is used to
	 * fetch a complete list of books from the database.
	 * </p>
	 */
	public static final String SELECT_QUERY = "SELECT * FROM onlinebookapp";

	/**
	 * SQL query string to insert a new record into the {@code onlinebookapp} table.
	 * <p>
	 * This query expects five parameters to be provided: bookId, title, author,
	 * category, and price. It is used to add a new book to the database.
	 * </p>
	 */
	public static final String INSERT_QUERY = "INSERT INTO onlinebookapp VALUES(?,?,?,?,?);";

	/**
	 * SQL query string to delete a record from the {@code onlinebookapp} table
	 * based on the bookId.
	 * <p>
	 * This query expects one parameter: bookId. It is used to remove a specific
	 * book from the database.
	 * </p>
	 */
	public static final String DELETE_QUERY = "DELETE FROM onlinebookapp WHERE bookId = ?";

	/**
	 * SQL query string to update a record in the {@code onlinebookapp} table based
	 * on the bookId.
	 * <p>
	 * This query should be corrected as it currently contains a mistake and is set
	 * to delete rather than update. It is used to modify an existing book record in
	 * the database.
	 * </p>
	 */
	public static final String UPDATE_QUERY = "UPDATE onlinebookapp SET title=?, author=?, category=?, price=? WHERE bookId = ?";

	/**
	 * SQL query string to select a record from the {@code onlinebookapp} table
	 * based on the bookId.
	 * <p>
	 * This query expects one parameter: bookId. It is used to retrieve a specific
	 * book's details from the database.
	 * </p>
	 */
	public static final String SELECT_BY_ID = "SELECT * FROM onlinebookapp WHERE bookId=?;";

	/**
	 * SQL query string to select records from the {@code onlinebookapp} table based
	 * on the author.
	 * <p>
	 * This query expects one parameter: author. It is used to retrieve all books by
	 * a specific author from the database.
	 * </p>
	 */
	public static final String SELECT_BY_AUTHOR = "SELECT * FROM onlinebookapp WHERE author =?;";

	/**
	 * SQL query string to select records from the {@code onlinebookapp} table based
	 * on the category.
	 * <p>
	 * This query expects one parameter: category. It is used to retrieve all books
	 * within a specific category from the database.
	 * </p>
	 */
	public static final String SELECT_BY_CATEGORY = "SELECT * FROM onlinebookapp WHERE category=?;";

	/**
	 * SQL query string to select records from the {@code onlinebookapp} table based
	 * on the price.
	 * <p>
	 * This query expects one parameter: price. It is used to retrieve all books
	 * priced at a specific value from the database.
	 * </p>
	 */
	public static final String SELECT_BY_PRICE = "SELECT * FROM onlinebookapp WHERE price=?;";
}
