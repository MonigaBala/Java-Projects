package com.onlinebookapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinebookapp.bean.Book;
import com.onlinebookapp.dao.ConnectionBean;
import com.onlinebookapp.exceptions.AuthorNotFoundException;
import com.onlinebookapp.exceptions.BookNotFoundException;
import com.onlinebookapp.exceptions.CategoryNotFoundException;
import com.onlinebookapp.exceptions.IdNotFoundException;
import com.onlinebookapp.exceptions.PriceNotAvailableException;
import com.onlinebookapp.util.Queries;

/**
 * Implementation of the {@link BookInterface} that provides methods for
 * managing book records in the online book application. This class implements
 * CRUD (Create, Read, Update, Delete) operations on book records using a SQL
 * database.
 * <p>
 * The class uses JDBC for database operations and manages connections through
 * the {@link ConnectionBean} utility. It handles SQL exceptions and custom
 * exceptions related to book operations.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class BookImpl implements BookInterface {

	/**
	 * Adds a new book record to the database.
	 * <p>
	 * This method prepares and executes an SQL INSERT statement to add the details
	 * of the provided {@link Book} object into the database. It handles the
	 * connection and closing of resources.
	 * </p>
	 * 
	 * @param book the {@link Book} object containing the details of the book to be
	 *             added.
	 * @throws SQLException if a database access error occurs or the SQL statement
	 *                      is invalid.
	 */
	@Override
	public void addBook(Book book) {
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			preparedStatement = connection.prepareStatement(Queries.INSERT_QUERY);
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, book.getCategory());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.execute();
			System.out.println("Book added successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
	}

	/**
	 * Deletes a specific book record based on the given book ID.
	 * <p>
	 * This method prepares and executes an SQL DELETE statement to remove the book
	 * record with the specified ID from the database. If the book ID does not
	 * exist, a {@link BookNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param bookId the ID of the book to be deleted.
	 * @return true if the delete operation was successful; false otherwise.
	 * @throws BookNotFoundException if no book with the specified ID is found.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	@Override
	public boolean deleteBook(int bookId) throws BookNotFoundException {
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		boolean value = false;
		try {
			preparedStatement = connection.prepareStatement(Queries.DELETE_QUERY);
			preparedStatement.setInt(1, bookId);
			value = preparedStatement.execute();
			if (value) {
				throw new BookNotFoundException("BookId Not Found. Cannot be Deleted");
			} else {
				System.out.println("Book Deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return value;
	}

	/**
	 * Updates the price of a specific book record based on the given book ID.
	 * <p>
	 * This method prepares and executes an SQL UPDATE statement to modify the price
	 * of the book identified by the given book ID. If the book ID does not exist, a
	 * {@link BookNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param bookId the ID of the book to be updated.
	 * @param price  the new price to be set for the book.
	 * @return true if the update operation was successful; false otherwise.
	 * @throws BookNotFoundException if no book with the specified ID is found.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	@Override
	public boolean updateBook(int bookId, double price) throws BookNotFoundException {
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		boolean result = false;
		try {
			preparedStatement = connection.prepareStatement(Queries.UPDATE_QUERY);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, bookId);
			result = preparedStatement.execute();
			if (result) {
				throw new BookNotFoundException("Book ID not found. Not updated.");
			}
			System.out.println("New Values Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return result;
	}

	/**
	 * Retrieves all book records from the database.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all book
	 * records from the database. It returns a list of {@link Book} objects
	 * representing the book records found. If no books are found, an empty list is
	 * returned.
	 * </p>
	 * 
	 * @return a {@link List} of {@link Book} objects representing all book records.
	 * @throws BookNotFoundException if no books are found in the database.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			ResultSet resultset;
			preparedStatement = connection.prepareStatement(Queries.SELECT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			while (resultset.next()) {
				Book book = new Book();
				book.setBookId(resultset.getInt(1));
				book.setTitle(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setCategory(resultset.getString(4));
				book.setPrice(resultset.getDouble(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		if (bookList.isEmpty()) {
			throw new BookNotFoundException("No books found in the database.");
		}
		return bookList;
	}

	/**
	 * Retrieves a specific book record based on the given book ID.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch the book
	 * record with the specified ID. If the book ID is not found, an
	 * {@link IdNotFoundException} is thrown. The method returns a {@link Book}
	 * object representing the found record.
	 * </p>
	 * 
	 * @param id the ID of the book to be retrieved.
	 * @return the {@link Book} object representing the book with the specified ID.
	 * @throws IdNotFoundException if no book with the specified ID is found.
	 * @throws SQLException        if a database access error occurs or the SQL
	 *                             statement is invalid.
	 */
	@Override
	public Book getBookById(int id) throws IdNotFoundException {
		Book book = null;
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next()) {
				throw new IdNotFoundException("Given BookID is not found. Try giving another ID.");
			}
			resultset.beforeFirst();
			while (resultset.next()) {
				book = new Book();
				book.setBookId(resultset.getInt(1));
				book.setTitle(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setCategory(resultset.getString(4));
				book.setPrice(resultset.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		if (book == null) {
			throw new IdNotFoundException("Given BookID is not found.");
		}
		return book;
	}

	/**
	 * Retrieves a list of books by a specific author.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all books
	 * written by the specified author. If no books are found for the given author,
	 * an {@link AuthorNotFoundException} is thrown. The method returns a list of
	 * {@link Book} objects representing the books by the specified author.
	 * </p>
	 * 
	 * @param author the name of the author whose books are to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books by the
	 *         specified author.
	 * @throws AuthorNotFoundException if no books are found for the specified
	 *                                 author.
	 * @throws SQLException            if a database access error occurs or the SQL
	 *                                 statement is invalid.
	 */
	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM onlinebookapp WHERE author = ?;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, author);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next()) {
				throw new AuthorNotFoundException("No books match your description.");
			}
			resultset.beforeFirst();
			while (resultset.next()) {
				Book book = new Book();
				book.setBookId(resultset.getInt(1));
				book.setTitle(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setCategory(resultset.getString(4));
				book.setPrice(resultset.getDouble(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		if (bookList.isEmpty()) {
			throw new AuthorNotFoundException("No books found for the specified author.");
		}
		return bookList;
	}

	/**
	 * Retrieves a list of books by a specific category.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all books
	 * in the specified category. If no books are found for the given category, a
	 * {@link CategoryNotFoundException} is thrown. The method returns a list of
	 * {@link Book} objects representing the books in the specified category.
	 * </p>
	 * 
	 * @param category the category of the books to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books in the
	 *         specified category.
	 * @throws CategoryNotFoundException if no books are found for the specified
	 *                                   category.
	 * @throws SQLException              if a database access error occurs or the
	 *                                   SQL statement is invalid.
	 */
	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_CATEGORY,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, category);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next()) {
				throw new CategoryNotFoundException("No books match your description.");
			}
			resultset.beforeFirst();
			while (resultset.next()) {
				Book book = new Book();
				book.setBookId(resultset.getInt(1));
				book.setTitle(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setCategory(resultset.getString(4));
				book.setPrice(resultset.getDouble(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		if (bookList.isEmpty()) {
			throw new CategoryNotFoundException("No books found in the specified category.");
		}
		return bookList;
	}

	/**
	 * Retrieves a list of books within a specific price range.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all books
	 * priced at the specified amount. If no books are found at the given price, a
	 * {@link PriceNotAvailableException} is thrown. The method returns a list of
	 * {@link Book} objects representing the books at the specified price.
	 * </p>
	 * 
	 * @param price the price of the books to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books priced at
	 *         the specified amount.
	 * @throws PriceNotAvailableException if no books are found at the specified
	 *                                    price.
	 * @throws SQLException               if a database access error occurs or the
	 *                                    SQL statement is invalid.
	 */
	@Override
	public List<Book> getBookByPrice(double price) throws PriceNotAvailableException {
		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_PRICE, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setDouble(1, price);
			ResultSet resultset = preparedStatement.executeQuery();
			if (!resultset.next()) {
				throw new PriceNotAvailableException("Books are not available at this price.");
			}
			resultset.beforeFirst();
			while (resultset.next()) {
				Book book = new Book();
				book.setBookId(resultset.getInt(1));
				book.setTitle(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setCategory(resultset.getString(4));
				book.setPrice(resultset.getDouble(5));
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		if (bookList.isEmpty()) {
			throw new PriceNotAvailableException("No books found at the specified price.");
		}
		return bookList;
	}
}
