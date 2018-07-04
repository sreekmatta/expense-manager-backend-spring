package com.expensegator.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/api/hello")
	public String helloWorld() {
		return "Hello from Server";
	}

	@PostMapping("/api/login")
	public void loginUser() {

	}

	@GetMapping("/api/register")
	public void registerUser() {

	}

	@GetMapping("/api/user/id")
	public void getUserByID() {

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
