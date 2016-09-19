package com.ex.service;

import org.springframework.stereotype.Component;

import com.ex.model.User;

@Component
public class UserService {
	
	public User auth(User user){
		
		User authUser = null;
		
		if("john".equals(user.getUsername()) && "123".equals(user.getPassword())){
			authUser = user;
		}else {
			authUser = null;
		}
		
		return authUser;
		
	}
	
	
}
