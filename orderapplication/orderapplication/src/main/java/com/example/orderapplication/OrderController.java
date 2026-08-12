package com.example.orderapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	OrderService os;
	
	@PostMapping("/orders")
	public String insert(@RequestBody Order o) {
		return os.insert(o);
		
	}
	
	@GetMapping("/retrieveorders")
	public List<Order> retrieve()
	{
		return os.retrieve();
	}
}
