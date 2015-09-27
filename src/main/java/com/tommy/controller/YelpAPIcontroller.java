package com.tommy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@Controller
@RequestMapping(value="/yelp" )
public class YelpAPIcontroller {

	@RequestMapping(value="/hello" ,method = {RequestMethod.GET,RequestMethod.POST}, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String userProfile(HttpServletRequest request){
		

	    Key customerKey = KeyFactory.createKey("Customer", "your name");
	    Entity customer = new Entity("Customer");
	    customer.setProperty("name", "your name");
	    customer.setProperty("email", "your email");

	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    datastore.put(customer); //save it
	    
	    return "hello";
	}
}
