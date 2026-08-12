package com.klu.restaurantapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantService rs;
	
	@PostMapping("/insert")
	public void insert(@RequestBody Restaurant r)
	{
		rs.insert(r);
	}
	
	@GetMapping("/restaurant")
	public List<Restaurant> retrieve()
	{
		return rs.retrieve();
	}
	
	@GetMapping("/restaurants/{id}")
	public Restaurant getOneRestaurant(@PathVariable int id)
	{
		return rs.getOneRestaurant(id);
	}
}
