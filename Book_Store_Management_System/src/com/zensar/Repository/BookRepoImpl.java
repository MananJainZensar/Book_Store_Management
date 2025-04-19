package com.zensar.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zensar.model.Book;
import com.zensar.utils.JDBCConnection;

public class BookRepoImpl implements BookRepoInterface{
	private static List<Book> books = new ArrayList<>();
	static {
		try(Connection con = JDBCConnection.createDBConnection()) {
			String query = "Select * From books";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				books.add(new Book(
						rs.getInt("id"),
	                    rs.getString("title"),
	                    rs.getString("author"),
	                    rs.getDouble("price"),
	                    rs.getDate("publish_date"),
	                    rs.getString("language"),
	                    rs.getString("category")
						));
			}
		} catch (SQLException e) {
			
			System.err.println("SQL Exception: " + e.getMessage());
		}
	}
	@Override
	public List<Book> displayBook() {
		return books;
	}
	//executeUpdate allows  DML, DDL,
	@Override
	public void addNewBook(Book book) {
		books.add(book);
		try(Connection con = JDBCConnection.createDBConnection()) {
			String query = "Insert into books(id,title,author,price,publish_date,language,category)values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setString(3,book.getAuthor());
			ps.setDouble(4, book.getPrice());
			ps.setDate(5, new java.sql.Date(book.getPublishDate().getTime()));//instead of just ps.setDate(5,book.getpublishDate()); we have written this long because prepared statements expects a java.sql.Date and not java.util.Date so we have to create object of java.sql.Date
			ps.setString(6,book.getLanguage());
			ps.setString(7, book.getCategory());
			ps.executeUpdate(); //This will do three things firstly send data which is in (?) using the driverClass and it executes them as a non-query statement
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("SQL Exception: " + e.getMessage());
		}
		
	}
}
