package com.zensar.model;

import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String author;
	private double price;
	private Date publishDate;
	private String language;
	private String category;
	public Book(int id, String title, String author, double price, Date publishDate, String language, String category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishDate = publishDate;
		this.language = language;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", publishDate="
				+ publishDate + ", language=" + language + ", category=" + category + "]";
	}
	
	
	
}
