package com.bookapp.client;

import java.util.List;
import java.util.Scanner;
import com.bookapp.bean.Book;
import com.bookapp.exceptions.AuthorNotFoundException;
import com.bookapp.exceptions.CategoryNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.exceptions.PriceNotAvailableException;
import com.bookapp.exceptions.TitleNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.IBook;

/**
 * The {@code BookClient} class is a client application that interacts with the
 * book management system. It provides a command-line interface for performing
 * various operations related to books, such as adding, retrieving, and sorting
 * books. This class serves as the entry point for interacting with the
 * implemented methods from the {@link IBook} interface.
 * 
 * <p>
 * The class demonstrates the use of a scanner to read user input from the
 * console, and it handles several types of exceptions related to book
 * operations, such as:
 * <ul>
 * <li>{@link AuthorNotFoundException} - Thrown when a book author is not
 * found.</li>
 * <li>{@link CategoryNotFoundException} - Thrown when a book category is not
 * found.</li>
 * <li>{@link IdNotFoundException} - Thrown when a book ID is not found.</li>
 * <li>{@link PriceNotAvailableException} - Thrown when the price of a book is
 * not available.</li>
 * <li>{@link TitleNotFoundException} - Thrown when a book title is not
 * found.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * The main functionality of this class includes:
 * </p>
 * <ul>
 * <li>Adding multiple books to the system with user-provided details.</li>
 * <li>Retrieving books based on various criteria such as ID, title, author,
 * category, and price.</li>
 * <li>Sorting books based on a specified field.</li>
 * <li>Providing a menu-driven interface to choose between different
 * operations.</li>
 * </ul>
 * 
 * <p>
 * The following options are available to the user:
 * </p>
 * <ul>
 * <li>List all books.</li>
 * <li>Get a book by its ID.</li>
 * <li>Get a book by its title.</li>
 * <li>Get a book by its author.</li>
 * <li>Get a book by its category.</li>
 * <li>Get a book by its price.</li>
 * <li>Sort books by a specified field.</li>
 * <li>Exit the application.</li>
 * </ul>
 * 
 * <p>
 * Errors are handled gracefully by catching specific exceptions for each
 * operation and displaying appropriate messages to the user. The application
 * continues to prompt the user for input until the user chooses to exit.
 * </p>
 * 
 * @author MonigaBalasubramanian
 */
public class BookClient {

	/**
	 * The entry point of the application. This method initializes the book
	 * management system and provides a command-line interface for the user to
	 * interact with the system. It handles user input, performs various operations
	 * on the book data, and manages exceptions related to book operations.
	 * 
	 * @param args command-line arguments (not used in this implementation)
	 */
	public static void main(String[] args) {

		// Interface reference for Book management system
		IBook bookInstance = new BookImpl();
		Book addingBooks = null;

		// Using try-with-resources to ensure the Scanner is closed properly
		try (Scanner sc = new Scanner(System.in)) {

			// Prompting the user to enter the number of books to be inserted
			System.out.println("Enter the number of books to be inserted: ");
			int numberOfBooks = sc.nextInt();

			// Collecting book details from the user
			for (int i = 1; i <= numberOfBooks; i++) {
				addingBooks = new Book();
				System.out.println("Values of the Book " + i);

				System.out.println("Enter the id of book " + i + ": ");
				int id = sc.nextInt();
				sc.nextLine(); // Consume newline
				addingBooks.setBookId(id);

				System.out.println("Enter the title of the book " + i + ": ");
				String title = sc.nextLine();
				addingBooks.setTitle(title);

				System.out.println("Enter the author of the book " + i + ": ");
				String author = sc.nextLine();
				addingBooks.setAuthor(author);

				System.out.println("Enter the category of the book " + i + ": ");
				String category = sc.nextLine();
				addingBooks.setCategory(category);

				System.out.println("Enter the price of the book " + i + ": ");
				double price = sc.nextDouble();
				addingBooks.setPrice(price);
				System.out.println();

				// Adding the book to the system
				bookInstance.addBook(addingBooks);
			}

			// Menu-driven interface for performing various operations
			String toContinue;
			do {
				System.out.println("Choose one option: ");
				System.out.println("1. List all books ");
				System.out.println("2. Get Book by ID ");
				System.out.println("3. Get Book by title ");
				System.out.println("4. Get Book by author ");
				System.out.println("5. Get Book by category ");
				System.out.println("6. Get Book by price ");
				System.out.println("7. Sort by field");
				System.out.println("8. Exit ");

				int choice = sc.nextInt();
				sc.nextLine(); // Consume newline

				// Processing user choices
				switch (choice) {
				case 1:
					System.out.println("List of all books: ");
					bookInstance.getAllBooks().forEach(System.out::println);
					break;

				case 2:
					System.out.println("Enter the book ID: ");
					try {
						int bID = sc.nextInt();
						sc.nextLine(); // Consume newline
						List<Book> booksById = bookInstance.getBookById(bID);
						booksById.forEach(System.out::println);
					} catch (IdNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					System.out.println("Enter the title of the book: ");
					String title = sc.nextLine();
					try {
						List<Book> booksByTitle = bookInstance.getBookByTitle(title);
						booksByTitle.forEach(System.out::println);
					} catch (TitleNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:
					System.out.println("Enter the author of the book: ");
					String author = sc.nextLine();
					try {
						List<Book> booksByAuthor = bookInstance.getBookByAuthor(author);
						booksByAuthor.forEach(System.out::println);
					} catch (AuthorNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					System.out.println("Enter the category of the book: ");
					String category = sc.nextLine();
					try {
						List<Book> booksByCategory = bookInstance.getBookByCategory(category);
						booksByCategory.forEach(System.out::println);
					} catch (CategoryNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 6:
					System.out.print("Enter price of the book: ");
					double price = sc.nextDouble();
					sc.nextLine(); // Consume newline
					try {
						List<Book> booksByPrice = bookInstance.getBookByPrice(price);
						booksByPrice.forEach(System.out::println);
					} catch (PriceNotAvailableException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 7:
					System.out.println("Enter the field: ");
					String field = sc.nextLine();
					List<Book> sortedByFields = bookInstance.sortByAnyField(field);
					sortedByFields.forEach(System.out::println);
					break;

				case 8:
					System.out.println("Exiting...");
					return;

				default:
					System.out.println("Invalid choice! Enter the correct choice..");
					break;
				}
				System.out.println("Do you want to continue(Yes/No): ");
				toContinue = sc.nextLine();
			} while (toContinue.equalsIgnoreCase("Yes"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
