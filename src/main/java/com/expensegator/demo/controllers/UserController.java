package com.expensegator.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensegator.demo.models.User;
import com.expensegator.demo.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserRepository userRepository;

	private String CURRENT_USER = "currentUser";

	private HttpSession currentSession;

	@GetMapping("/api/login")
	public ResponseEntity<HttpStatus> loginUser(@RequestParam("email") String email,
			@RequestParam("password") String password, HttpSession session) {
		List<User> users = userRepository.findUserByCredentials(email, password);
		if (users.isEmpty()) {
			return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
		}

		session.setAttribute(CURRENT_USER, users.get(0).getId()); // store user id in currentUser
		currentSession = session;
		return ResponseEntity.ok(HttpStatus.OK);
	}

	@PostMapping("/api/user/create")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user, HttpSession session) {
		User savedUser = userRepository.save(user);
		if (savedUser != null) {
			session.setAttribute(CURRENT_USER, savedUser.getId()); // store user id in currentUser
			currentSession = session;
			return ResponseEntity.ok(HttpStatus.OK);
		}
		return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/api/profile")
	public User profile() {
		User currentUser = (User) currentSession.getAttribute(CURRENT_USER);
		return currentUser;
	}

	@GetMapping("/api/user/{id}")
	public Optional<User> getUserByID(@PathVariable("id") int id) {
		return userRepository.findById(id);
	}

	@GetMapping("api/user")
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/api/user/email/{email}")
	public List<User> findUserByEmail(@PathVariable("email") String email) {
		return userRepository.findUserByEmail("%"+email+"%");
	}

	@PutMapping("/api/user/id")
	public void updateUser() {

	}

	@DeleteMapping("/api/user/id")
	public void deleteUser() {

	}

	@GetMapping("/api/get/session")
	public Integer validateSession() {
		if (currentSession == null) {
			return null;
		}
		if (currentSession.getValueNames().length == 0) {
			return null;
		}

		return (Integer) currentSession.getAttribute(CURRENT_USER);

	}

	@GetMapping("/api/logout")
	public String invalidateSession(HttpSession session) {
		if (currentSession != null && currentSession.getAttribute(CURRENT_USER) != null) {
			currentSession.invalidate();
		}
		return "session invalidated";
	}

}
