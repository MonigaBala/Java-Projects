/**
 * Package provides a POJO class with field members and is used in the Project OnlineBookAppJDBC in other packages and classes.
 * @author MonigaBalasubramanian 
 */
package com.onlinebookapp.bean;

/**
 * A POJO class Book with its private fields, constructor, getters, setters and
 * toString() method.
 * 
 * @author MonigaBalasubramanian
 */
public class Book {

	private int bookId;
	private String title;
	private String author;
	private String category;
	private double price;

	/**
	 * Default Constructor to initialize the instance variables.
	 * 
	 * @see Book#Book(int, String, String, String, double)
	 */
	public Book() {
		super();
	}

	/**
	 * Constructor to initialize using field members.
	 * 
	 * @param bookId
	 * @param title
	 * @param author
	 * @param category
	 * @param price
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
	 * int getBookId() method is used to get the bookId of the book instance.
	 * 
	 * @return bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * void setBookId() method is used to set values for bookId field.
	 * 
	 * @param bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * String getTitle() method is used to get the title of the book instance.
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * void setTitle() method is used to set the value for title field.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * String getAuthor() method is used to get the author of the book instance.
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * void setAuthor() method is used to set the value for author field.
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * String getCategory() method is used to get the category of the book instance.
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * void setCategory() method is used to set the value for category field.
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * double getPrice() method is used to get the price of the book instance.
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * void setPrice() method is used to set the value for price field.
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * String toString() method is a overridden method to return all the field
	 * members as a String value.
	 * 
	 * @return a string representation of the book
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}

}
