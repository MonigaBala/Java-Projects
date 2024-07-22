package com.onlinebookapp.services;

/**
 *  Interface BookInterface with public and abstract methods.
 *  
 *   @author MonigaBalasubramanian
 */
import java.util.List;

import com.onlinebookapp.bean.Book;
import com.onlinebookapp.exceptions.AuthorNotFoundException;
import com.onlinebookapp.exceptions.BookNotFoundException;
import com.onlinebookapp.exceptions.CategoryNotFoundException;
import com.onlinebookapp.exceptions.IdNotFoundException;
import com.onlinebookapp.exceptions.PriceNotAvailableException;

public interface BookInterface {

	void addBook(Book book);

	boolean deleteBook(int bookId) throws BookNotFoundException;

	boolean updateBook(int bookid, double price) throws BookNotFoundException;

	List<Book> getAllBooks() throws BookNotFoundException;

	Book getBookById(int id) throws IdNotFoundException;

	List<Book> getBookByAuthor(String author) throws AuthorNotFoundException;

	List<Book> getBookByCategory(String category) throws CategoryNotFoundException;

	List<Book> getBookByPrice(double price) throws PriceNotAvailableException;

}
