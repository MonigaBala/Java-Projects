/**
 * Package contains service classes that implements the code logic for the OnlineBookApp.
 */
package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.bookapp.bean.Book;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.exceptions.PriceNotAvailableException;
import com.bookapp.exceptions.TitleNotFoundException;

/**
 * Class BookImpl which implements the interface IBook and the methods are
 * implemented here.
 * 
 * @author MonigaBalasubramanian
 */
public class BookImpl implements IBook {

	List<Book> books = new ArrayList<>();

	/**
	 * void addBook() method adds books of type Book.
	 */
	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	/**
	 * List<Book> getAllBooks() method returns the list of books available using
	 * stream operations to sort.
	 * 
	 * @return books i.e.List<Book> books = new ArrayList<>() is initialized to
	 *         store the list of books.
	 */
	@Override
	public List<Book> getAllBooks() {
		return books.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).toList();
	}

	/**
	 * List<Book> getBookById() method returns the list of books by checking the
	 * bookId and if it's not present it will throws an IdNotFoundException.
	 * 
	 * @throws IdNotFoundException
	 * @return books based on the given bookId.
	 * 
	 */
	@Override
	public List<Book> getBookById(int bookId) throws IdNotFoundException {
		List<Book> booksById = books.stream().filter(book -> book.getBookId() == bookId)
				.sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		if (booksById.isEmpty()) {
			throw new IdNotFoundException("Id not found: " + bookId);
		}
		return booksById;
	}

	/**
	 * List<Book> getBookByTitle() method returns the list of books by checking the
	 * title and if it's not present it will throws an TitleNotFoundException.
	 * 
	 * @throws TitleNotFoundException
	 * @return books
	 */
	@Override
	public List<Book> getBookByTitle(String title) throws TitleNotFoundException {

		List<Book> booksByTitle = books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title))
				.sorted((o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle())).collect(Collectors.toList());
		if (booksByTitle.isEmpty()) {
			throw new TitleNotFoundException("Title not found: " + title);
		}
		return booksByTitle;
	}

	/**
	 * List<Book> getBookByAuthor() method returns the list of books by checking the
	 * author and if it's not present it will throws an AuthorNotFoundException.
	 * 
	 * @throws AuthorNotFoundException
	 * @return books
	 */
	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		List<Book> booksByAuthor = books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
				.sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		if (booksByAuthor.isEmpty()) {
			throw new AuthorNotFoundException("Author not found: " + author);
		}
		return booksByAuthor;
	}

	/**
	 * List<Book> getBookByCategory() method returns the list of books by checking
	 * the category and if it's not present it will throws an
	 * CategoryNotFoundException.
	 * 
	 * @throws CategoryNotFoundException
	 * @return books
	 */
	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> booksByCategory = books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category))
				.sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		if (booksByCategory.isEmpty()) {
			throw new CategoryNotFoundException("Category not found: " + category);
		}
		return booksByCategory;
	}

	/**
	 * List<Book> getBookByPrice() method returns the list of books by checking the
	 * price and if it's not present it will throws an PriceNotAvailableException.
	 * 
	 * @throws PriceNotAvailableException
	 * @return books
	 */
	@Override
	public List<Book> getBookByPrice(double price) throws PriceNotAvailableException {
		List<Book> booksByPrice = books.stream().filter(book -> book.getPrice() < 1000 && book.getPrice() == price)
				.sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		if (booksByPrice.isEmpty()) {
			throw new PriceNotAvailableException("Books are not available to this price..");
		}
		return booksByPrice;
	}

	/**
	 * List<Book> sortByAnyField() method returns the list of books by checking the
	 * console input field for getting the book.
	 * 
	 * @return books
	 */
	@Override
	public List<Book> sortByAnyField(String field) {
		List<Book> sortedByField = new ArrayList<>();
		switch (field) {
		case "Title":
			sortedByField = books.stream().sorted((o1, o2) -> o1.getTitle().compareToIgnoreCase(o2.getTitle()))
					.collect(Collectors.toList());
			break;

		case "ID":
			sortedByField = books.stream().sorted(Comparator.comparingInt(Book::getBookId))
					.collect(Collectors.toList());
			break;

		case "Author":
			sortedByField = books.stream().sorted((o1, o2) -> o1.getAuthor().compareToIgnoreCase(o2.getAuthor()))
					.collect(Collectors.toList());
			break;

		case "Category":
			sortedByField = books.stream().sorted((o1, o2) -> o1.getCategory().compareToIgnoreCase(o2.getCategory()))
					.collect(Collectors.toList());
			break;

		case "Price":
			sortedByField = books.stream().sorted(Comparator.comparingDouble(Book::getPrice))
					.collect(Collectors.toList());
			break;

		default:
			System.out.println("Invalid field: " + field);
			break;
		}
		return sortedByField;
	}
}