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
import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.MessageType;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;
import com.tommy.entity.Question;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {



	@RequestMapping(value="/hello" ,method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String userProfile(HttpServletRequest request){
		

	    Key customerKey = KeyFactory.createKey("Customer", "your name");
	    Entity customer = new Entity("Customer", customerKey);
	    customer.setProperty("name", "your name");
	    customer.setProperty("email", "your email");

	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    datastore.put(customer); //save it
	    
	    return "hello";
	}
	


}
