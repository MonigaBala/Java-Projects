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
 * {@code BookImpl} is an implementation of the {@link IBook} interface. This
 * class provides concrete implementations for managing a collection of books.
 * It allows for adding books, retrieving them based on various criteria, and
 * sorting them by different fields.
 * 
 * <p>
 * The class maintains an internal list of {@link Book} objects and provides
 * methods to perform operations on this list. The operations include adding
 * books, retrieving books by ID, title, author, category, or price, and sorting
 * books by different fields.
 * 
 * <p>
 * Exception handling is integrated into the methods to provide meaningful
 * messages when books are not found based on the search criteria.
 * 
 * @author MonigaBalasubramanian
 * @see IBook
 * @see Book
 */
public class BookImpl implements IBook {

	// List to store books
	private List<Book> books = new ArrayList<>();

	/**
	 * Adds a new {@link Book} to the list of books.
	 * 
	 * @param book The {@link Book} object to be added to the list.
	 */
	@Override
	public void addBook(Book book) {
		books.add(book);
	}

	/**
	 * Retrieves a list of all {@link Book} objects, sorted by their title.
	 * 
	 * @return A list of all books, sorted by title.
	 */
	@Override
	public List<Book> getAllBooks() {
		return books.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
	}

	/**
	 * Retrieves a list of {@link Book} objects that match the specified book ID.
	 * Throws an {@link IdNotFoundException} if no books are found with the given
	 * ID.
	 * 
	 * @param bookId The ID of the book to search for.
	 * @return A list of books with the specified ID.
	 * @throws IdNotFoundException If no books are found with the given ID.
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
	 * Retrieves a list of {@link Book} objects that match the specified title.
	 * Throws a {@link TitleNotFoundException} if no books are found with the given
	 * title.
	 * 
	 * @param title The title of the book to search for.
	 * @return A list of books with the specified title.
	 * @throws TitleNotFoundException If no books are found with the given title.
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
	 * Retrieves a list of {@link Book} objects that match the specified author.
	 * Throws an {@link AuthorNotFoundException} if no books are found with the
	 * given author.
	 * 
	 * @param author The author of the book to search for.
	 * @return A list of books with the specified author.
	 * @throws AuthorNotFoundException If no books are found with the given author.
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
	 * Retrieves a list of {@link Book} objects that match the specified category.
	 * Throws a {@link CategoryNotFoundException} if no books are found with the
	 * given category.
	 * 
	 * @param category The category of the book to search for.
	 * @return A list of books with the specified category.
	 * @throws CategoryNotFoundException If no books are found with the given
	 *                                   category.
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
	 * Retrieves a list of {@link Book} objects that match the specified price.
	 * Throws a {@link PriceNotAvailableException} if no books are found with the
	 * given price.
	 * 
	 * @param price The price of the book to search for.
	 * @return A list of books with the specified price.
	 * @throws PriceNotAvailableException If no books are found within the specified
	 *                                    price range.
	 */
	@Override
	public List<Book> getBookByPrice(double price) throws PriceNotAvailableException {
		List<Book> booksByPrice = books.stream().filter(book -> book.getPrice() < 1000 && book.getPrice() == price)
				.sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		if (booksByPrice.isEmpty()) {
			throw new PriceNotAvailableException("Books are not available to this price.");
		}
		return booksByPrice;
	}

	/**
	 * Sorts the list of {@link Book} objects based on the specified field.
	 * 
	 * <p>
	 * The sorting fields can be "Title", "ID", "Author", "Category", or "Price". If
	 * an invalid field is provided, it prints an error message.
	 * 
	 * @param field The field by which to sort the books.
	 * @return A list of books sorted by the specified field.
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
