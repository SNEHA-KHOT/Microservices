package com.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.UserService.Dto.userReqDto;
import com.UserService.service.UserService;

@RestController
public class UserController {
	
	@Autowired 
	private UserService userService;
	

	
	@GetMapping("v1/users")
	public Object getAllUsers() {
	return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUsers());
		
	}
	
	@GetMapping("v1/user/{userId}")
	public Object getUser(@PathVariable ("userId") long userId) {
	return ResponseEntity.status(HttpStatus.CREATED).body(userService.getUser(userId));
		
	}
	@PostMapping("v1/user/add")
	public Object addUser(@RequestBody userReqDto req) {
     return  ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(req));
		
	}
	
	@PutMapping("v1/user/update")
	public Object updateUser(@RequestBody userReqDto req) {
     return  ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(req));
		
	}
	
	@PutMapping("v1/user/delete/{userId}")
	public Object deactivateUser(@PathVariable  long userId) {
     return  ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteUser(userId));
		
	}

}
