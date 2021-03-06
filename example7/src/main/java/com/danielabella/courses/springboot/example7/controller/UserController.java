package com.danielabella.courses.springboot.example7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielabella.courses.springboot.example7.domain.User;
import com.danielabella.courses.springboot.example7.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<User> > listAllUsers() {
		
		return new ResponseEntity< List<User> >
		(userService.listAllUsers(), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String id) {
		
		User user = userService.getById(id);
		
		return user == null ? 
				new ResponseEntity<User>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {

		try {
			userService.save(user);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public UserService getUserService() {
		return userService;
	}
}
