package com.klu.librarymanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	BookService bs;
	
	@PostMapping("/insert")
	public String insert(@RequestBody Book b) {
		return bs.insert(b);
		
	}
	@GetMapping("/list")
	public List<Book> retrieve(){
		return bs.retrieve();
	}
}
