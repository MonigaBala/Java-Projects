package com.onlinebookapp.main;

import java.util.List;
import java.util.Scanner;

import com.onlinebookapp.bean.Book;
import com.onlinebookapp.exceptions.AuthorNotFoundException;
import com.onlinebookapp.exceptions.BookNotFoundException;
import com.onlinebookapp.exceptions.CategoryNotFoundException;
import com.onlinebookapp.exceptions.IdNotFoundException;
import com.onlinebookapp.exceptions.PriceNotAvailableException;
import com.onlinebookapp.services.BookImpl;
import com.onlinebookapp.services.BookInterface;

/**
 * The main class for the console-based Online Book Application.
 * <p>
 * This class provides a command-line interface for users to interact with the
 * book management system. It allows users to perform various operations such as
 * adding, deleting, updating, and retrieving books based on different criteria.
 * The interactions are handled through a menu-driven approach, and user input
 * is processed to invoke the corresponding methods from the
 * {@link BookInterface} implementation.
 * </p>
 * 
 * @author MonigaBalasubramanian
 * @version 1.0
 * @since 1.0
 */
public class BookClient {

	/**
	 * The main method that drives the console-based application.
	 * <p>
	 * This method presents a menu to the user with various options for book
	 * management. Based on the user's choice, it performs operations such as
	 * adding, deleting, updating, and retrieving books. It interacts with the
	 * {@link BookInterface} implementation to execute these operations and handles
	 * exceptions that may arise during the process.
	 * </p>
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BookInterface bookImpl = new BookImpl();
		Book book = null;
		String continueOrNot;
		do {
			System.out.println("Enter your choice in the given list below: ");
			System.out.println(
					"1. Add Book \n2. Delete Book \n3. Update Book\n4. Get All Books\n5. Get BookByID \n6. Get BookByAuthor \n7. Get BookByCategory \n8. Get BookByPrice");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter the number of books to be added: ");
				int numberOfBooks = scanner.nextInt();
				for (int i = 0; i < numberOfBooks; i++) {
					book = new Book();
					System.out.println("Enter the bookId, title, author, category, price of Book " + (i + 1) + ": ");
					try {
						int bookId = scanner.nextInt();
						scanner.nextLine();
						book.setBookId(bookId);
						String title = scanner.nextLine();
						book.setTitle(title);
						String author = scanner.nextLine();
						book.setAuthor(author);
						String category = scanner.nextLine();
						book.setCategory(category);
						double price = scanner.nextDouble();
						book.setPrice(price);
						bookImpl.addBook(book);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			case 2:
				System.out.println("Enter the number of books to be deleted: ");
				int numberOfBooksToBeDeleted = scanner.nextInt();
				scanner.nextLine();
				for (int i = 0; i < numberOfBooksToBeDeleted; i++) {
					try {
						System.out.println("Enter the book id to delete: ");
						int bookId = scanner.nextInt();
						scanner.nextLine();
						bookImpl.deleteBook(bookId);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 3:
				System.out.println("Enter the number of books to be updated: ");
				int numberOfBooksToBeUpdated = scanner.nextInt();
				for (int i = 0; i < numberOfBooksToBeUpdated; i++) {
					try {
						System.out.println("Enter the book id and price to update the book price: ");
						int bookId = scanner.nextInt();
						scanner.nextLine();
						double price = scanner.nextDouble();
						scanner.nextLine();
						bookImpl.updateBook(bookId, price);
					} catch (BookNotFoundException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 4:
				System.out.println("Getting all the books.. ");
				List<Book> bookList;
				try {
					bookList = bookImpl.getAllBooks();
					bookList.forEach(System.out::println);
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter the book id to get the book details: ");
					int bookID = scanner.nextInt();
					scanner.nextLine();
					System.out.println(bookImpl.getBookById(bookID));
				} catch (IdNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				List<Book> bookList1;
				try {
					System.out.println("Enter the author name: ");
					String author = scanner.nextLine();
					bookList1 = bookImpl.getBookByAuthor(author);
					bookList1.forEach(System.out::println);
				} catch (AuthorNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				try {
					System.out.println("Enter the category: ");
					String category = scanner.nextLine();
					bookList1 = bookImpl.getBookByCategory(category);
					bookList1.forEach(System.out::println);
				} catch (CategoryNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					System.out.println("Enter the price: ");
					double price = scanner.nextDouble();
					scanner.nextLine();
					bookList1 = bookImpl.getBookByPrice(price);
					bookList1.forEach(System.out::println);
				} catch (PriceNotAvailableException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 8.");
			}
			System.out.println("Do you want to continue (Yes/ No): ");
			continueOrNot = scanner.nextLine();

		} while (continueOrNot.equalsIgnoreCase("Yes"));

		scanner.close();

	}

}
