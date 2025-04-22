package com.zensar.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.zensar.Repository.BookRepoImpl;
import com.zensar.model.Book;

public class BookServiceImplementation implements BookServiceInterface {
	private BookRepoImpl bookRepo;
	
	public BookServiceImplementation() {
		this.bookRepo = new BookRepoImpl();
	}
	@Override
	public void displayBooksInAscendingOrder() {
		// TODO Auto-generated method stub
		bookRepo.displayBook();
	}

	@Override
	public void displayBookFromOldToNewAsPerPublishDate() {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream()
				.sorted((b1, b2) -> b1.getPublishDate().compareTo(b2.getPublishDate())).collect(Collectors.toList());
		books.forEach(System.out::println);
		
	}

	@Override
	public void searchUsingBookTitle(String title) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream()
				.filter(book -> book.getTitle().equalsIgnoreCase(title))
				.collect(Collectors.toList());
		books.forEach(System.out::println);

	}

	@Override
	public void searchUsingAuthorName(String author) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
		books.forEach(System.out::println);
		
	}

	@Override
	public void displayBooksOfParticularLanguage(String language) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream().filter(book -> book.getLanguage().equalsIgnoreCase(language)).collect(Collectors.toList());
		books.forEach(System.out::println);
	}

	@Override
	public void displayBooksInParticularCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
		books.forEach(System.out::println);
		
	}

	@Override
	public void displayTotalBooksInBookStore() {
		// TODO Auto-generated method stub
		long count = bookRepo.displayBook().size();
		System.out.println("The total books in book store is: " + count);
		
	}

	@Override
	public void displayBooksInParticularPriceRange(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.displayBook().stream()
				.filter(book -> book.getPrice() >= minPrice && book.getPrice() <= maxPrice)
				.collect(Collectors.toList());
		books.forEach(System.out::println);

		
	}

	@Override
	public void printTotalPriceOfAllBooks() {
		// TODO Auto-generated method stub
		double totalPrice = bookRepo.displayBook().stream().mapToDouble(book -> book.getPrice()).sum();
		System.out.println("The total price of all books is: " + totalPrice);
		
	}

	@Override
	public void printDetailsOfMostExpensiveBook() {
		List<Book> books = bookRepo.displayBook();
		books.stream().max(Comparator.comparingDouble(book -> book.getPrice())).ifPresent(book->System.out.println("The deatils of most expensive book are: { " + book + "}"));;
		
	}

}
