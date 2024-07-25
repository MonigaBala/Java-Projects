/**
 * Provides custom exception classes used in the BookApp application.
 * 
 * <p>
 * This package contains exceptions that are specifically tailored for handling
 * various error scenarios related to book management. Each exception extends
 * the {@link java.lang.Exception} class and provides more specific error
 * handling for conditions such as when an author, category, ID, price, or title
 * is not found.
 * </p>
 * 
 * <p>
 * The following exceptions are included in this package:
 * </p>
 * <ul>
 * <li>{@link com.bookapp.exceptions.AuthorNotFoundException} - Thrown when an
 * author is not found in the system.</li>
 * <li>{@link com.bookapp.exceptions.CategoryNotFoundException} - Thrown when a
 * category is not found in the system.</li>
 * <li>{@link com.bookapp.exceptions.IdNotFoundException} - Thrown when an ID is
 * not found in the system.</li>
 * <li>{@link com.bookapp.exceptions.PriceNotAvailableException} - Thrown when
 * the price of an item is not available.</li>
 * <li>{@link com.bookapp.exceptions.TitleNotFoundException} - Thrown when a
 * book title is not found in the system.</li>
 * </ul>
 * 
 * <p>
 * Each exception class includes:
 * </p>
 * <ul>
 * <li>A default constructor that initializes the exception without a specific
 * message.</li>
 * <li>A parameterized constructor that allows for specifying a detail message
 * to describe the error.</li>
 * </ul>
 * 
 * @see java.lang.Exception
 * @author MonigaBalasubramanian
 */
package com.bookapp.exceptions;
