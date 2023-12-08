package com.jwt.example.services;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.example.models.User;


@Service
public class UserService {
	private List<User> store=new ArrayList<>();

	public UserService() {
		
		store.add(new User(UUID.randomUUID().toString(),"Ashwini Ingole","ingoleashwini33@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Harsh Ingole","harsha33@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Ankit Ingole","ankit33@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(),"Gautam shukla","gautam33@gmail.com"));
	}
	public List<User> getUsers()
	{
		return this.store;
	}
	

}
