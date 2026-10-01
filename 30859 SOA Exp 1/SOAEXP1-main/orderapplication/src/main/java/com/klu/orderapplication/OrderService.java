package com.klu.orderapplication;

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
		//localhost:8081/restaurant/1
		RestaurantDTO dto=rt.getForObject(url+"/"+o.getRid(), RestaurantDTO.class);
		if(dto==null)
		{
			return "Restaurant not exits";
		}
		or.save(o);
		return "Order Place Successfully";
	}

	public List<Order> retrieve()
	{
		return or.findAll();
	}

}
