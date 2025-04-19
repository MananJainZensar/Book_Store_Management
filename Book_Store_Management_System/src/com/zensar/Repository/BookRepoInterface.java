package com.zensar.Repository;

import java.util.List;

import com.zensar.model.Book;

public interface BookRepoInterface {
	List<Book> displayBook();
	void addNewBook(Book book);
}
