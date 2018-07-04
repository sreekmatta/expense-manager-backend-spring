package com.expensegator.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.models.User;
import com.expensegator.demo.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/api/login")
	public void loginUser() {

	}

	@GetMapping("/api/user/create")
	public ResponseEntity createUser(@RequestBody User user) {
		if(userRepository.save(user) != null) {;
			return ResponseEntity.ok(HttpStatus.OK);
		} 
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/api/user/id")
	public void getUserByID() {

	}

	@GetMapping("api/user")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/api/user/username")
	public void getUserByUsername() {

	}

	@PutMapping("/api/user/id")
	public void updateUser() {

	}

	@DeleteMapping("/api/user/id")
	public void deleteUser() {

	}
}
