package com.tommy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value="/hello" ,method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String userProfile(HttpServletRequest request){
		
		return "hello world";
	}
}
