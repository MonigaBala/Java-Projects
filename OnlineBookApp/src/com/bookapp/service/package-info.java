/**
 * Contains the service layer for the Book application, including interfaces and
 * their implementations for managing book-related operations.
 * 
 * <p>
 * The service layer provides methods for adding books, retrieving books by
 * various attributes (e.g., ID, title, author, category, price), and sorting
 * books based on different fields. The interface {@link IBook} defines these
 * methods, and {@link BookImpl} is a concrete implementation of this interface.
 * 
 * <p>
 * The service methods may throw custom exceptions if the requested operations
 * cannot be performed, such as {@link IdNotFoundException},
 * {@link TitleNotFoundException}, {@link AuthorNotFoundException},
 * {@link CategoryNotFoundException}, and {@link PriceNotAvailableException}.
 * 
 * @see IBook
 * @see BookImpl
 * @see com.bookapp.bean.Book
 * @see com.bookapp.exceptions.IdNotFoundException
 * @see com.bookapp.exceptions.TitleNotFoundException
 * @see com.bookapp.exceptions.AuthorNotFoundException
 * @see com.bookapp.exceptions.CategoryNotFoundException
 * @see com.bookapp.exceptions.PriceNotAvailableException
 * @author MonigaBalasubramanian
 */
package com.bookapp.service;
