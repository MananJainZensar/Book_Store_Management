package com.zensar.Service;

public interface BookServiceInterface {
	void displayBooksInAscendingOrder();
	void displayBookFromOldToNewAsPerPublishDate();
    void searchUsingBookTitle(String title);
    void searchUsingAuthorName(String author);
    void displayBooksOfParticularLanguage(String language);
    void displayBooksInParticularCategory(String category);
    void displayTotalBooksInBookStore();
    void displayBooksInParticularPriceRange(double minPrice, double maxPrice);
    void printTotalPriceOfAllBooks();
    void printDetailsOfMostExpensiveBook();
}
