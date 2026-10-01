package com.example.LibraryManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepo br;
	
	public String insert( BookClass b) {
		br.save(b);
		return "Record inserted";
	}
	
	public List<BookClass> retrieve()
	{
		return br.findAll();
	}
}
