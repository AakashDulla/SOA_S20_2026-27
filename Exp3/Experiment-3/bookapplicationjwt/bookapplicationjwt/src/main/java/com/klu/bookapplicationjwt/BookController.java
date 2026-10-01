package com.klu.bookapplicationjwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@GetMapping("/insert")
	public String insert(@RequestParam int bno, @RequestParam String bname)
	{
		return "The Book Details are:"+bno+" "+bname;
	}
}
