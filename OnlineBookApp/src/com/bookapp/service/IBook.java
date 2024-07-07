package com.bookapp.service;

/** Interface IBook with public and abstract methods throws different Exceptions.
 * 
 * @author MonigaBalasubramanian
 */
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.exceptions.PriceNotAvailableException;
import com.bookapp.exceptions.TitleNotFoundException;

public interface IBook {

	void addBook(Book book);

	List<Book> getAllBooks();

	List<Book> getBookById(int bookId) throws IdNotFoundException;

	List<Book> getBookByTitle(String title) throws TitleNotFoundException;

	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;

	List<Book> sortByAnyField(String field);
}
