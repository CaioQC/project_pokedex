package com.project.pokedex.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pokedex.entity.User;
import com.project.pokedex.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){
		var userId = userService.createUser(createUserDTO);
		return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
	}
	
	@GetMapping
	public ResponseEntity<User> findUser(@PathVariable("userId") String body){
		return null;
	}
}
