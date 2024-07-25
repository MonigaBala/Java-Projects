package com.onlinebookapp.services;

import java.util.List;

import com.onlinebookapp.bean.Book;
import com.onlinebookapp.exceptions.AuthorNotFoundException;
import com.onlinebookapp.exceptions.BookNotFoundException;
import com.onlinebookapp.exceptions.CategoryNotFoundException;
import com.onlinebookapp.exceptions.IdNotFoundException;
import com.onlinebookapp.exceptions.PriceNotAvailableException;

/**
 * Interface for managing book operations in an online book application.
 * <p>
 * This interface defines the methods for performing various operations on book
 * records such as adding, deleting, updating, and retrieving books from the
 * database. Each method may throw specific exceptions when operations fail due
 * to issues like book not found or invalid input.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public interface BookInterface {

	/**
	 * Adds a new book record to the database.
	 * <p>
	 * This method takes a {@link Book} object as input and adds it to the database.
	 * The book details are extracted from the object and inserted into the
	 * database.
	 * </p>
	 * 
	 * @param book the {@link Book} object containing the details of the book to be
	 *             added.
	 * @throws SQLException if a database access error occurs or the SQL statement
	 *                      is invalid.
	 */
	void addBook(Book book);

	/**
	 * Deletes a book record from the database based on the given book ID.
	 * <p>
	 * This method prepares and executes an SQL DELETE statement to remove the book
	 * record with the specified ID from the database. If the book ID does not
	 * exist, a {@link BookNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param bookId the ID of the book to be deleted.
	 * @return true if the book was successfully deleted; false otherwise.
	 * @throws BookNotFoundException if no book with the specified ID is found in
	 *                               the database.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	boolean deleteBook(int bookId) throws BookNotFoundException;

	/**
	 * Updates the price of an existing book record based on the given book ID.
	 * <p>
	 * This method prepares and executes an SQL UPDATE statement to modify the price
	 * of the book identified by the given book ID. If the book ID does not exist, a
	 * {@link BookNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param bookId the ID of the book to be updated.
	 * @param price  the new price to set for the book.
	 * @return true if the book price was successfully updated; false otherwise.
	 * @throws BookNotFoundException if no book with the specified ID is found in
	 *                               the database.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	boolean updateBook(int bookId, double price) throws BookNotFoundException;

	/**
	 * Retrieves all book records from the database.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all book
	 * records from the database. It returns a list of {@link Book} objects
	 * representing each book record found. If no books are found, an empty list is
	 * returned.
	 * </p>
	 * 
	 * @return a {@link List} of {@link Book} objects representing all book records.
	 * @throws BookNotFoundException if no books are found in the database.
	 * @throws SQLException          if a database access error occurs or the SQL
	 *                               statement is invalid.
	 */
	List<Book> getAllBooks() throws BookNotFoundException;

	/**
	 * Retrieves a specific book record by its ID.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch the book
	 * record with the specified ID. If the book ID is not found, an
	 * {@link IdNotFoundException} is thrown. The method returns a {@link Book}
	 * object representing the found record.
	 * </p>
	 * 
	 * @param id the ID of the book to be retrieved.
	 * @return the {@link Book} object representing the book with the specified ID.
	 * @throws IdNotFoundException if no book with the specified ID is found in the
	 *                             database.
	 * @throws SQLException        if a database access error occurs or the SQL
	 *                             statement is invalid.
	 */
	Book getBookById(int id) throws IdNotFoundException;

	/**
	 * Retrieves book records based on the author's name.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all book
	 * records by the specified author. If no books are found by the given author,
	 * an {@link AuthorNotFoundException} is thrown. The method returns a list of
	 * {@link Book} objects representing the books written by the specified author.
	 * </p>
	 * 
	 * @param author the name of the author whose books are to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books by the
	 *         specified author.
	 * @throws AuthorNotFoundException if no books by the specified author are
	 *                                 found.
	 * @throws SQLException            if a database access error occurs or the SQL
	 *                                 statement is invalid.
	 */
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	/**
	 * Retrieves book records based on the book's category.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all book
	 * records that belong to the specified category. If no books are found in the
	 * given category, a {@link CategoryNotFoundException} is thrown. The method
	 * returns a list of {@link Book} objects representing the books in the
	 * specified category.
	 * </p>
	 * 
	 * @param category the category of the books to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books in the
	 *         specified category.
	 * @throws CategoryNotFoundException if no books in the specified category are
	 *                                   found.
	 * @throws SQLException              if a database access error occurs or the
	 *                                   SQL statement is invalid.
	 */
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	/**
	 * Retrieves book records based on the book's price.
	 * <p>
	 * This method prepares and executes an SQL SELECT statement to fetch all book
	 * records that match the specified price. If no books are found at the given
	 * price, a {@link PriceNotAvailableException} is thrown. The method returns a
	 * list of {@link Book} objects representing the books at the specified price.
	 * </p>
	 * 
	 * @param price the price of the books to be retrieved.
	 * @return a {@link List} of {@link Book} objects representing books at the
	 *         specified price.
	 * @throws PriceNotAvailableException if no books are available at the specified
	 *                                    price.
	 * @throws SQLException               if a database access error occurs or the
	 *                                    SQL statement is invalid.
	 */
	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;
}
