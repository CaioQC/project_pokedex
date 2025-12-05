package com.project.pokedex.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pokedex.controller.CreateUserDTO;
import com.project.pokedex.entity.User;
import com.project.pokedex.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public UUID createUser(CreateUserDTO createUserDTO) {
		var entity = new User(null,
				createUserDTO.username(),
				createUserDTO.email(),
				createUserDTO.password(),
				Instant.now(),
				null);
		
		var userSaved = userRepository.save(entity);
		
		return userSaved.getUserId();
	}
}
