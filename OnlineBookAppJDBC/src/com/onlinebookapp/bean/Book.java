package com.onlinebookapp.bean;

/**
 * Represents a book in the online book application. This class is a Plain Old
 * Java Object (POJO) that encapsulates the details of a book including its ID,
 * title, author, category, and price.
 * <p>
 * This class provides methods to get and set the values of these fields, as
 * well as a {@code toString()} method to get a string representation of the
 * book instance.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @version 1.0
 * @since 1.0
 */
public class Book {

	private int bookId;
	private String title;
	private String author;
	private String category;
	private double price;

	/**
	 * Default constructor that initializes a new instance of the {@code Book} class
	 * with default values.
	 * <p>
	 * The default constructor is provided for frameworks and libraries that require
	 * a no-argument constructor to instantiate objects.
	 * </p>
	 * 
	 * @see Book#Book(int, String, String, String, double)
	 */
	public Book() {
		super();
	}

	/**
	 * Parameterized constructor that initializes a new instance of the {@code Book}
	 * class with specified values.
	 * 
	 * @param bookId   the unique identifier of the book
	 * @param title    the title of the book
	 * @param author   the author of the book
	 * @param category the category of the book
	 * @param price    the price of the book
	 */
	public Book(int bookId, String title, String author, String category, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	/**
	 * This method gets the unique identifier of the book.
	 * 
	 * @return the book ID
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * This method sets the unique identifier of the book.
	 * 
	 * @param bookId the unique identifier to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * This method gets the title of the book.
	 * 
	 * @return the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method sets the title of the book.
	 * 
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method gets the author of the book.
	 * 
	 * @return the author of the book
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * This method sets the author of the book.
	 * 
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * This method gets the category of the book.
	 * 
	 * @return the category of the book
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * This method sets the category of the book.
	 * 
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * This method gets the price of the book.
	 * 
	 * @return the price of the book
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method sets the price of the book.
	 * 
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method returns a string representation of the {@code Book} object.
	 * <p>
	 * This method returns a string that contains the values of all the fields of
	 * the book instance. The string representation is useful for debugging and
	 * logging purposes.
	 * </p>
	 * 
	 * @return a string representation of the book instance
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}

}
