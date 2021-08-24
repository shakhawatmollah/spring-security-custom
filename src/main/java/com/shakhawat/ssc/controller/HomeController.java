package com.shakhawat.ssc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "Welcome to Spring-Boot-Security Home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "Welcome to Admin panel";
	}

}
