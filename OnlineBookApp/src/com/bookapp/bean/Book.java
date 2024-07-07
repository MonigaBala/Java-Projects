package com.bookapp.bean;

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

	public Book() {
		super();
	}

	// Constructor to initialize.
	public Book(int bookId, String title, String author, String category, double price) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	// Getters and Setters to change and get the values.
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// toString() method is overridden to return the values.
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}

}
