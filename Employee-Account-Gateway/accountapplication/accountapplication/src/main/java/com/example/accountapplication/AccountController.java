package com.example.accountapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	@GetMapping("/acc")
	public String getAccount(@RequestParam String pan,@RequestParam String aadhar)
	{
		return "the details are"+pan+""+aadhar;	
	}
}
