package com.klu.jwtcreation;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	String key="this is spring boot jwt creation";
	SecretKey secretkey= Keys.hmacShaKeyFor(key.getBytes());
	
	public String generateJwt(User u1)
	{
		
	}
}
