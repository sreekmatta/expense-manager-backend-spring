package com.example.personalexpensesmanagerspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/api/hello")
	public String helloWorld() {
		return "Hello from Server";
	}
}
