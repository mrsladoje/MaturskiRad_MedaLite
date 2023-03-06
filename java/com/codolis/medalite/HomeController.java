package com.codolis.medalite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, you're authenticated now!";
	}
	
	@GetMapping("/hello1")
	public String hello1() {
		return "Hello Ganymede!";
	}
	
	@GetMapping("/")
	public String jasas() {
		return "Ja sas Victoria!";
	}
	
	@GetMapping("/customError")
	public String kastom() {
		return "Authentication Exception!";
	}
}
