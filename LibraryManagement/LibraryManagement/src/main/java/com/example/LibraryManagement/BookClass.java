package com.example.LibraryManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookClass {
	@Id
	int id;
	String title;
	String author;
	String isbn;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "BookClass [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	public BookClass(int id, String title, String author, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	public BookClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
