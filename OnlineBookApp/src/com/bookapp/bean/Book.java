package com.bookapp.bean;

/**
 * Represents a book with details such as ID, title, author, category, and
 * price. This class is used to encapsulate the attributes of a book and provide
 * getter and setter methods to access and modify these attributes.
 * 
 * <p>
 * Example usage:
 * </p>
 * 
 * <pre>
 * Book book = new Book(1, "Java Programming", "John Doe", "Education", 29.99);
 * System.out.println(book);
 * </pre>
 * 
 * @author MonigaBalasubramanian
 */
public class Book {

	/**
	 * The unique identifier for the book.
	 */
	private int bookId;

	/**
	 * The title of the book.
	 */
	private String title;

	/**
	 * The author of the book.
	 */
	private String author;

	/**
	 * The category or genre of the book.
	 */
	private String category;

	/**
	 * The price of the book.
	 */
	private double price;

	/**
	 * Default constructor that initializes a new instance of {@code Book} with
	 * default values. This constructor is used to create an empty book object that
	 * can be set up later.
	 * 
	 * @see #Book(int, String, String, String, double)
	 */
	public Book() {
		super();
	}

	/**
	 * Constructs a new instance of {@code Book} with the specified values for all
	 * fields. This constructor is used to create a book object with predefined
	 * values.
	 * 
	 * @param bookId   the unique identifier for the book
	 * @param title    the title of the book
	 * @param author   the author of the book
	 * @param category the category or genre of the book
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
	 * @param bookId the new book ID
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * This method gets the title of the book.
	 * 
	 * @return the book title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method sets the title of the book.
	 * 
	 * @param title the new book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method gets the author of the book.
	 * 
	 * @return the book author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * This method sets the author of the book.
	 * 
	 * @param author the new book author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * This method gets the category or genre of the book.
	 * 
	 * @return the book category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * This method sets the category or genre of the book.
	 * 
	 * @param category the new book category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * This method gets the price of the book.
	 * 
	 * @return the book price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This method sets the price of the book.
	 * 
	 * @param price the new book price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method returns a string representation of the Book object. The String
	 * includes the book's ID, title, author, category, and price.
	 * 
	 * @return a String representation of the book
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}
}
