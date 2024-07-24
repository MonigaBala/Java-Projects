/**
 * Package contains Client class to access the OnlineBookApp.
 */
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
 * Client Class BookClient which is used to access the implemented methods
 * through the instance.
 * 
 * @author MonigaBalasubramanian
 */
public class BookClient {

	public static void main(String[] args) {

		// DMD Interface reference = Implementation object.
		IBook bookInstance = new BookImpl();
		Book addingBooks = null;

		// Using try with resource to display, get books through various cases with an
		// instance.

		try (Scanner sc = new Scanner(System.in)) {

			// Alternate method to insert the books.
			/**
			 * bookInstance.addBook((new Book(101, "The Silent Patient", "Alex Michaelides",
			 * "Thriller", 999.00))); bookInstance.addBook((new Book(102, "The Hobbit",
			 * "J.R.R.Tolkien", "Fantasy", 1200.18))); bookInstance.addBook((new Book(103,
			 * "The Catcher in the Rye", "J.D.Salinger", "Fiction", 983.18)));
			 * bookInstance.addBook((new Book(104, "A Brief History of Time", "Stephen
			 * Hawking", "Science", 965.35))); bookInstance.addBook((new Book(105, "The
			 * Great Gatsby", "F.Scott Fitzgerald", "Classic", 737.18)));
			 */

			System.out.println("Enter the number of books to be inserted: ");
			int numberOfBooks = sc.nextInt();

			// Getting the fields of a book through console input.
			for (int i = 1; i <= numberOfBooks; i++) {

				// As everytime a new book is added, the book instance is created here.
				addingBooks = new Book();
				System.out.println("Values of the Book " + i);

				System.out.println("Enter the id of book " + i + ": ");
				int id = sc.nextInt();
				sc.nextLine();
				addingBooks.setBookId(id);

				System.out.println("Enter the title book " + i + ": ");
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
				// Alternate way of adding to the bookInstance
				// bookInstance.addBook(new Book(id, title, author, category, price));
				bookInstance.addBook(addingBooks);
			}

			// Using a do while loop to get various inputs and switch between the cases.
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
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("List of all books: ");
					bookInstance.getAllBooks().forEach(System.out::println);
					break;

				case 2:
					System.out.println("Enter the book ID: ");
					try {
						int bID = sc.nextInt();
						sc.nextLine();
						try {
							List<Book> booksById = bookInstance.getBookById(bID);
							booksById.forEach(System.out::println);
						} catch (IdNotFoundException e) {
							System.out.println(e.getMessage());
						}
					} catch (Exception e) {
						e.printStackTrace();
						sc.nextLine();
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
					sc.nextLine();
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
			} while (toContinue.equalsIgnoreCase(toContinue));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
