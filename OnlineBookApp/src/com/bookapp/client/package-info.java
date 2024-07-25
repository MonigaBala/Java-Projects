/**
 * The {@code com.bookapp.client} package contains classes that serve as the
 * client-side interface for interacting with the book management system. This
 * package provides the main entry point for the application, allowing users to
 * perform various operations related to books through a command-line interface.
 * 
 * <p>
 * The primary class in this package is {@link BookClient}. This class:
 * <ul>
 * <li>Initializes the book management system using the
 * {@link com.bookapp.service.IBook} interface.</li>
 * <li>Provides a user-friendly command-line menu for performing book-related
 * operations such as:</li>
 * <ul>
 * <li>Adding new books to the system.</li>
 * <li>Retrieving books by different criteria, including ID, title, author,
 * category, and price.</li>
 * <li>Sorting books by various fields.</li>
 * </ul>
 * <li>Handles various exceptions related to book operations, including:</li>
 * <ul>
 * <li>{@link com.bookapp.exceptions.AuthorNotFoundException}</li>
 * <li>{@link com.bookapp.exceptions.CategoryNotFoundException}</li>
 * <li>{@link com.bookapp.exceptions.IdNotFoundException}</li>
 * <li>{@link com.bookapp.exceptions.PriceNotAvailableException}</li>
 * <li>{@link com.bookapp.exceptions.TitleNotFoundException}</li>
 * </ul>
 * <li>Ensures robust error handling and user interaction.</li>
 * </ul>
 * 
 * <p>
 * The package facilitates a clear separation between the client-side user
 * interface and the underlying book management logic, allowing for a modular
 * and maintainable design.
 * </p>
 * 
 * @see com.bookapp.service
 * @see com.bookapp.bean
 * @see com.bookapp.exceptions
 * 
 * @author MonigaBalasubramanian
 */
package com.bookapp.client;
