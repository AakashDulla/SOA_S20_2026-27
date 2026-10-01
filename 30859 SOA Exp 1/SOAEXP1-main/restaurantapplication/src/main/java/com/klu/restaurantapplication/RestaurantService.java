package com.klu.restaurantapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository rr;

    public void insert(Restaurant r) {
        rr.save(r);
    }

    public List<Restaurant> retrieve() {
        return rr.findAll();
    }
    
    public Restaurant getOneRestaurant( int id)
    {
    	return rr.findById(id).orElse(null);
    	
    }
}