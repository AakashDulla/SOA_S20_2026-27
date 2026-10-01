package com.klu.librarymanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	int bid;
	String title;
	String author;
	String isbn;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	public Book(int bid, String title, String author, String isbn) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
     
	
	
}
