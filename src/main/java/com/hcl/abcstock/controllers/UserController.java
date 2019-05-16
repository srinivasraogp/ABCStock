package com.hcl.abcstock.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.abcstock.models.User;
import com.hcl.abcstock.services.UserService;

@RestController
@RequestMapping(path="/api")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;  

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listUsers() {
		logger.info("inside listUsers");
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			logger.info("Users not available");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
}
