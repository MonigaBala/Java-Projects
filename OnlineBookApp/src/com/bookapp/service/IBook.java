package com.bookapp.service;

import java.util.List;
import com.bookapp.bean.Book;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.exceptions.PriceNotAvailableException;
import com.bookapp.exceptions.TitleNotFoundException;

/**
 * {@code IBook} is an interface that defines methods for managing a collection
 * of {@link Book} objects. It includes methods for adding books, retrieving
 * books based on various criteria, and sorting books. Implementations of this
 * interface will provide concrete behavior for these methods.
 * 
 * <p>
 * Each method may throw specific exceptions if the requested operation cannot
 * be performed, such as when books are not found based on the search criteria.
 * 
 * @author MonigaBalasubramanian
 * @see Book
 * @see AuthorNotFoundException
 * @see CategoryNotFoundException
 * @see IdNotFoundException
 * @see PriceNotAvailableException
 * @see TitleNotFoundException
 */
public interface IBook {

	/**
	 * Adds a {@link Book} to the collection.
	 * 
	 * <p>
	 * This method allows a new book to be added to the internal list of books
	 * maintained by the implementation.
	 * 
	 * @param book The {@link Book} object to be added to the collection.
	 */
	void addBook(Book book);

	/**
	 * Retrieves a list of all {@link Book} objects in the collection.
	 * 
	 * <p>
	 * This method returns a complete list of books, typically sorted or ordered as
	 * defined by the implementation.
	 * 
	 * @return A list of all {@link Book} objects.
	 */
	List<Book> getAllBooks();

	/**
	 * Retrieves a list of {@link Book} objects that match the specified book ID.
	 * 
	 * <p>
	 * This method searches for books with the given ID. If no books are found with
	 * that ID, an {@link IdNotFoundException} is thrown.
	 * 
	 * @param bookId The ID of the book to search for.
	 * @return A list of books with the specified ID.
	 * @throws IdNotFoundException If no books are found with the given ID.
	 */
	List<Book> getBookById(int bookId) throws IdNotFoundException;

	/**
	 * Retrieves a list of {@link Book} objects that match the specified title.
	 * 
	 * <p>
	 * This method searches for books with the given title. If no books are found
	 * with that title, a {@link TitleNotFoundException} is thrown.
	 * 
	 * @param title The title of the book to search for.
	 * @return A list of books with the specified title.
	 * @throws TitleNotFoundException If no books are found with the given title.
	 */
	List<Book> getBookByTitle(String title) throws TitleNotFoundException;

	/**
	 * Retrieves a list of {@link Book} objects that match the specified author.
	 * 
	 * <p>
	 * This method searches for books with the given author. If no books are found
	 * with that author, an {@link AuthorNotFoundException} is thrown.
	 * 
	 * @param author The author of the book to search for.
	 * @return A list of books with the specified author.
	 * @throws AuthorNotFoundException If no books are found with the given author.
	 */
	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	/**
	 * Retrieves a list of {@link Book} objects that match the specified category.
	 * 
	 * <p>
	 * This method searches for books in the specified category. If no books are
	 * found in that category, a {@link CategoryNotFoundException} is thrown.
	 * 
	 * @param category The category of the book to search for.
	 * @return A list of books in the specified category.
	 * @throws CategoryNotFoundException If no books are found in the given
	 *                                   category.
	 */
	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	/**
	 * Retrieves a list of {@link Book} objects that match the specified price.
	 * 
	 * <p>
	 * This method searches for books with the specified price. If no books are
	 * found at that price, a {@link PriceNotAvailableException} is thrown.
	 * 
	 * @param price The price of the book to search for.
	 * @return A list of books with the specified price.
	 * @throws PriceNotAvailableException If no books are found at the given price.
	 */
	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;

	/**
	 * Sorts the list of {@link Book} objects based on the specified field.
	 * 
	 * <p>
	 * This method allows the list of books to be sorted based on a specified field,
	 * such as "ID", "Title", "Author", "Category", or "Price". If an invalid field
	 * is provided, it may result in an error or default behavior as defined by the
	 * implementation.
	 * 
	 * @param field The field by which to sort the books. Valid options include
	 *              "ID", "Title", "Author", "Category", or "Price".
	 * @return A list of books sorted by the specified field.
	 */
	List<Book> sortByAnyField(String field);
}
