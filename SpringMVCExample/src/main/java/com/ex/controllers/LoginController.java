package com.ex.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ex.model.User;
import com.ex.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap){
		System.out.println("GET login");
		
		User emptyUser = new User();
		modelMap.addAttribute("user", emptyUser);
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("login");
//		
//		mav.addObject("someKey", new Object());
//		mav.addAllObjects(modelMap);
//		return mav;
		
		System.out.println("POST login");
		
		if(bindingResult.hasErrors()){
			//ASSERT: validation failed
			return "login";
		}
		//ASSERT: validation successful
		
		System.out.println(user);
		User authUser = userService.auth(user);
		
		if(authUser != null){
			//ASSERT: authentication successful
			return "redirect:home";
		}else {
			//ASSERT: authentication failed
			modelMap.addAttribute("errorMessage", "Username/Password incorrect");
//			modelMap.addAttribute("errorMessage", "Please try again");

			return "login";	
		}
		
		
	}
	
	
}
