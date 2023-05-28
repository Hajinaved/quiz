package com.academy.quiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String defaultApi() {
		return "Server is up and running";
	}
	
	@GetMapping("/test")
	public String testApi() {
		return "Hello World!";
	}
	
}
