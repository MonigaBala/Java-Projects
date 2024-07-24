/**
 * Package consists of service classes that declaration and implementation of the code logics.
 */
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
 * Implementation Class BookImpl with overridden methods to use various methods.
 * 
 * @author MonigaBalasubramanian
 */
public class BookImpl implements BookInterface {

	/**
	 * void addBook() method adds the number of book the user needs to the database.
	 * 
	 * @author MonigaBalasubramanian
	 * @param book
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
	 * boolean deleteBook() method deletes specific record based on the bookId
	 * given.
	 * 
	 * @author MonigaBalasubramanian
	 * @param bookId
	 * @throws BookNotFoundException
	 * @return value [value is true in default]
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
			if (value == true) {
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
	 * boolean updateBook() method updates the record values based on the given
	 * criteria.
	 * 
	 * @author MonigaBalasubramanian
	 * @param bookId
	 * @param price
	 * @return result [true or false]
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
			if (result == true) {
				throw new BookNotFoundException("Book ID not found. Not updated.");
			}
			System.out.println(" New Values Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return result;
	}

	/**
	 * List<Book> getAllBooks() method returns all the book records in the database
	 * as a List of Books.
	 * 
	 * @author MonigaBalasubramanian
	 * @return bookList i.e.List<Book> bookList = new ArrayList<>() is created to
	 *         store all book records.
	 */
	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {

		List<Book> bookList = new ArrayList<Book>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		Book book = null;
		try {
			ResultSet resultset;
			preparedStatement = connection.prepareStatement(Queries.SELECT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			while (resultset.next()) {
				book = new Book();
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
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return bookList;
	}

	/**
	 * Book getBookById() method returns specific book by the given bookId.
	 * 
	 * @author MonigaBalasubramanian
	 * @param id
	 * @return book i.e. A book instance.
	 */
	@Override
	public Book getBookById(int id) throws IdNotFoundException {

		Book book = null;
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		try {
			book = new Book();
			ResultSet resultset;
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setInt(1, id);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			if (!resultset.next())
				throw new IdNotFoundException("Given BookID is not found. Try giving other ID.");
			resultset.beforeFirst();
			while (resultset.next()) {
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
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return book;
	}

	/**
	 * List<Book> getBookByAuthor() method returns the list of books of specific
	 * author.
	 * 
	 * @author MonigaBalasubramanian
	 * @param author
	 * @return bookList i.e. An instance of List<Book> is bookList.
	 */
	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {

		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		Book book = null;
		ResultSet resultset = null;

		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM onlinebookapp WHERE author =?;",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, author);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			if (!resultset.next())
				throw new AuthorNotFoundException("No books match your description.");
			resultset.beforeFirst();
			while (resultset.next()) {
				book = new Book();
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
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return bookList;
	}

	/**
	 * List<Book> getBookByCategory() method returns all the books as a list from
	 * the database by the given category.
	 * 
	 * @author MonigaBalasubramanian
	 * @param category
	 * @return bookList
	 */
	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {

		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		Book book = null;
		try {
			ResultSet resultset;
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_CATEGORY,
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setString(1, category);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			if (!resultset.next())
				throw new CategoryNotFoundException("No books match your description.");
			resultset.beforeFirst();
			while (resultset.next()) {
				book = new Book();
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
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return bookList;
	}

	/**
	 * List<Book> getBookByPrice() method returns the books as a list by the given
	 * specific price and throws an exception if it's not found.
	 * 
	 * @author MonigaBalasubramanian
	 * @param price
	 * @return bookList
	 */
	@Override
	public List<Book> getBookByPrice(double price) throws PriceNotAvailableException {

		List<Book> bookList = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		Connection connection = ConnectionBean.openConnection();
		Book book = null;
		try {
			ResultSet resultset;
			preparedStatement = connection.prepareStatement(Queries.SELECT_BY_PRICE, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setDouble(1, price);
			resultset = preparedStatement.executeQuery();
			resultset.beforeFirst();
			if (!resultset.next())
				throw new PriceNotAvailableException("Books are not available in this price..");
			resultset.beforeFirst();
			while (resultset.next()) {
				book = new Book();
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
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionBean.closeConnection();
		}
		return bookList;

	}

}
