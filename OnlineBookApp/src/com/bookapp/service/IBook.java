/**
 * Package contains service classes that implements the code logic for the OnlineBookApp.
 */
package com.bookapp.service;

import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.exceptions.PriceNotAvailableException;
import com.bookapp.exceptions.TitleNotFoundException;

/**
 * Interface IBook with public and abstract methods that throws different
 * Exceptions.
 * 
 * @author MonigaBalasubramanian
 */

public interface IBook {

	/**
	 * void addBook() method adds the book instance to a List of type Book
	 * List<Book>.
	 * 
	 * @param book
	 */
	void addBook(Book book);

	/**
	 * List<Book> getAllBooks() method retrieves all the books available in the Book
	 * List.
	 * 
	 * @return List<Book>
	 */
	List<Book> getAllBooks();

	/**
	 * List<Book> getBookById() method retrieves specific book record based on the
	 * given bookId.
	 * 
	 * @param bookId
	 * @return List<Book>
	 * @throws IdNotFoundException
	 */
	List<Book> getBookById(int bookId) throws IdNotFoundException;

	/**
	 * List<Book> getBookByTitle() method retrieves specific book record based on
	 * the given title.
	 * 
	 * @param title
	 * @return List<Book>
	 * @throws TitleNotFoundException
	 */
	List<Book> getBookByTitle(String title) throws TitleNotFoundException;

	/**
	 * List<Book> getBookByAuthor() method retrieves book records based on the given
	 * author.
	 * 
	 * @param author
	 * @return List<Book>
	 * @throws AuthorNotFoundException
	 */
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	/**
	 * List<Book> getBookByCategory() method retrieves specific book records based
	 * on the given category.
	 * 
	 * @param category
	 * @return List<Book>
	 * @throws CategoryNotFoundException
	 */
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	/**
	 * List<Book> getBookByPrice() method retrieves specific book records based on
	 * the given price.
	 * 
	 * @param price
	 * @return List<Book>
	 * @throws PriceNotAvailableException
	 */
	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;

	/**
	 * List<Book> sortByAnyField() method sorts the list of books based on the given
	 * field( Id, title, author, category, price).
	 * 
	 * @param field
	 * @return List<Book>
	 */
	List<Book> sortByAnyField(String field);
}
