package com.zensar.Controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.zensar.Repository.BookRepoImpl;
import com.zensar.Service.BookServiceImplementation;
import com.zensar.model.Book;

public class BookController  {
	public static void main(String[] args) {
		BookRepoImpl bookRepo = new BookRepoImpl();
		BookServiceImplementation bookService = new BookServiceImplementation();
		
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		
		while(!exit) {
			System.out.println("       ");
			System.out.println("=============Book Store Database===============");
			List<Book> testbook = bookRepo.displayBook();
			for(Book book: testbook) {
				System.out.println(book);
			}
			System.out.println("=============Book Store Database Ends===============");
			System.out.println("       ");
			System.out.println("       ");
			System.out.println("====Menu====");
			System.out.println("1. Display books in Ascending Order");
			System.out.println("2. Display books from Old to new as per publish date");
			System.out.println("3. Search Using book title");
			System.out.println("4. Search Using author name");
			System.out.println("5. Display books of particular language");
			System.out.println("6. Display books in particular category");
			System.out.println("7. Display total books in book store");
			System.out.println("8. Display books in particular price range");
			System.out.println("9. Print total price of all books");
			System.out.println("10. Print details of most expensive book");
			System.out.println("11. Add new book");
			System.out.println("12. Exit");
			System.out.println("Enter your choice: ");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println("       ");
			System.out.println("       ");
			switch (choice) {
				case 1:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					bookService.displayBooksInAscendingOrder();
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 2:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					bookService.displayBookFromOldToNewAsPerPublishDate();
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 3:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the title of the book: ");
					String title = scanner.nextLine();
					bookService.searchUsingBookTitle(title);
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 4:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the Author name: ");
					String author = scanner.nextLine();
					bookService.searchUsingAuthorName(author);
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 5:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the language: ");
					String language = scanner.nextLine();
					bookService.displayBooksOfParticularLanguage(language);
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 6:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the category: ");
					String category = scanner.nextLine();
					bookService.displayBooksInParticularCategory(category);
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 7:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					bookService.displayTotalBooksInBookStore();
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 8:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the price range: ");
					int minPrice = scanner.nextInt();
					int maxPrice = scanner.nextInt();
					
					bookService.displayBooksInParticularPriceRange(minPrice, maxPrice);
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 9:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					bookService.printTotalPriceOfAllBooks();
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 10:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					bookService.printDetailsOfMostExpensiveBook();
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 11:
					System.out.println("==========Operation===========");
					System.out.println("       ");
					System.out.println("Enter the ID of book");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the title of book");
					String newTitle = scanner.nextLine();
					System.out.println("Enter the author of book");
					String newAuthor = scanner.nextLine();
					System.out.println("Enter the price of book");
					double newPrice = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter the publish date of book (yyyy-mm-dd)");
					String dateStr = scanner.nextLine();
					Date publishDate = java.sql.Date.valueOf(dateStr);
					System.out.println("Enter the language of book");
					String newLanguage = scanner.nextLine();
					System.out.println("Enter the category of book");
					String newCategory = scanner.nextLine();
					Book newBook = new Book(id, newTitle, newAuthor, newPrice, publishDate, newLanguage, newCategory);
					bookRepo.addNewBook(newBook);
					System.out.println("New book added sucessfully !");
					System.out.println("       ");
					System.out.println("==========Operation===========");
					break;
				case 12:
					exit = true;
					System.out.println("Exiting....");
					break;
				default:
					System.out.println("Invalid Choice, Please try again");
					break;
			}
			
		}
		scanner.close();
	}
}
