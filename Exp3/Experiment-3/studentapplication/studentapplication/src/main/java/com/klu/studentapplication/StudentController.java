package com.klu.studentapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@GetMapping("/insert")
	public String insert(@RequestParam int sno, @RequestParam String sname)
	{
		return "The Student is:"+sno+" "+sname;
	}
}
