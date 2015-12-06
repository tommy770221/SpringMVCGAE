package com.tommy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tommy.entity.User;
import com.tommy.entity.repository.UserRepository;

@Controller
public class LoginController {
	 @Autowired
	 UserRepository userRepository;
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String login(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		User user=new User();
		user.setPassword("test");
		user.setUsername("username");
		user.setEmail("userEmail");
		userRepository.save(user);
		
		
		return "login";
	}
	
	@RequestMapping(value = "/manu", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public String manu(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		
		return "page/manu";
	}
	
	@RequestMapping(value = "/jpa", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	@ResponseBody
	public String jpa(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Model model) {
		User user=new User();
		user=userRepository.findByUsername("username");
		System.out.println(user.getUsername());
		
		user=userRepository.findByEmail("userEmail");
		System.out.println(user.getEmail());
		
		
		return "page/manu";
	}
	
	
}
