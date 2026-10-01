package com.example.employeeapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@GetMapping("/get")
	public String getEmp(@RequestParam int eno,@RequestParam String ename)
	{
		return "The details are:"+eno+""+ename;
	}
}
