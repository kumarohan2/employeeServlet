package com.lti.service;

import java.util.HashMap;
import java.util.Iterator;

import com.sun.javafx.collections.MappingChange.Map;

public class InMemoryLoginService { 
	
	private HashMap<String, String> users = new HashMap< >();
	
	public InMemoryLoginService() {
	
		users.put("sid", "123");
		users.put("shinde", "456");
		users.put("roh","786");
		}
	
	public boolean isValidUser(String username,String password) {
           if(users.containsKey(username))
        	   if(users.get(username).equals(password))
        		   return true;
           return false;
	}
	}

