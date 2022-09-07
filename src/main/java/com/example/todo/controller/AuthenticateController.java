package com.example.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
public class AuthenticateController {

	@GetMapping("/authenticate")
	public AuthenticateBean authentication() {
		return new AuthenticateBean("User authentication successfull");
	}
}
