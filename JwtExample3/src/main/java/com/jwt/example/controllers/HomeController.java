package com.jwt.example.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.models.User;
import com.jwt.example.services.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private UserService userservice;
	// get mapping// http://localhost:8081/home/users
	// postmapping// http://localhost:8081/auth/login
	@GetMapping("/users")
	public List<User> getUser()
	{
		System.out.println("getting users");
		return userservice.getUsers();
		
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal)
	{
		return principal.getName();
	}

}
