package com.example.orderapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
	 @Autowired
	 OrderRepository or;
	 
	 @Value("${restaurant.url}")
	 String url;
	 
	 @Autowired
	 RestTemplate rt;
	 
	 
	 
	 public String insert( Order o) 
	 {	
		 	RestaurantDTO dto = rt.getForObject(url+"/"+o.getRestid(), RestaurantDTO.class);
		 	
		 	if(dto==null)
		 	{
		 		return "Restaurant does not exist";
		 	}
			or.save(o);
			
			return "Order placed successfully";
			
		}
	 
	 public List<Order> retrieve()
		{
			return or.findAll();
		}
	 
}
