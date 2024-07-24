/**
 * Package consists of service classes that declaration and implementation of the code logics.
 */
package com.onlinebookapp.services;

import java.util.List;

import com.onlinebookapp.bean.Book;
import com.onlinebookapp.exceptions.AuthorNotFoundException;
import com.onlinebookapp.exceptions.BookNotFoundException;
import com.onlinebookapp.exceptions.CategoryNotFoundException;
import com.onlinebookapp.exceptions.IdNotFoundException;
import com.onlinebookapp.exceptions.PriceNotAvailableException;

/**
 * Interface BookInterface with public and abstract methods.
 * 
 * @author MonigaBalasubramanian
 */

public interface BookInterface {

	/**
	 * void addBook() method adds book into Book.
	 * 
	 * @param book
	 */
	void addBook(Book book);

	/**
	 * boolean deleteBook() method deletes a specific record based on the parameter
	 * passed.
	 * 
	 * @param bookId
	 * @return value [true or false]
	 * @throws BookNotFoundException
	 */
	boolean deleteBook(int bookId) throws BookNotFoundException;

	/**
	 * boolean updateBook() method updates the data based on the given criteria.
	 * 
	 * @param bookid
	 * @param price
	 * @return value [ true or false]
	 * @throws BookNotFoundException
	 */
	boolean updateBook(int bookid, double price) throws BookNotFoundException;

	/**
	 * List<Book> getAllBooks() method retrieves all the book records available.
	 * 
	 * @return List<Book>
	 * @throws BookNotFoundException
	 */
	List<Book> getAllBooks() throws BookNotFoundException;

	/**
	 * Book getBookById() method retrieves a specific book record based on the given
	 * id.
	 * 
	 * @param id
	 * @return book i.e. A Book instance
	 * @throws IdNotFoundException
	 */
	Book getBookById(int id) throws IdNotFoundException;

	/**
	 * List<Book> getBookByAuthor() method retrieves the records based on the given
	 * author.
	 * 
	 * @param author
	 * @return bookList i.e. List<Book> bookList;
	 * @throws AuthorNotFoundException
	 */
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	/**
	 * List<Book> getBookByCategory() method retrieves the records that maps the
	 * given category.
	 * 
	 * @param category
	 * @return bookList i.e. List<Book> bookList;
	 * @throws CategoryNotFoundException
	 */
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	/**
	 * List<Book> getBookByPrice() method retrieves the records that matches the
	 * given price.
	 * 
	 * @param price
	 * @return bookList i.e. List<Book> bookList;
	 * @throws PriceNotAvailableException
	 */
	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;

}
