package com.klu.librarymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	 @Autowired
	BookRepo br;
	 public String insert(Book b) {
		 br.save(b);
		 return "Record inserted";
			
		}
	 public List<Book> retrieve(){
		 return br.findAll();
	 }
}
