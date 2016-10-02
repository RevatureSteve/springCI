package com.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.dao.UserDao;
import com.ex.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
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
