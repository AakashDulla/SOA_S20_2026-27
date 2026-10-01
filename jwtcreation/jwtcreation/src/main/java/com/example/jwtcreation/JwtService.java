package com.example.jwtcreation;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
	String key = "This is Spring Boot jwt creation";
	SecretKey secretkey = Keys.hmacShaKeyFor(key.getBytes());
	
}
