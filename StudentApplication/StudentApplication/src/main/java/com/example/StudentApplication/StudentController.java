package com.example.StudentApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {
	@GetMapping("/student")
	public Student get()
	{
		return new Student(101,"Aakash");
	}

}
