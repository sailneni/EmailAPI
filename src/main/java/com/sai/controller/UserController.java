package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/contact/{email}")
//	public String getContact(@PathVariable String email) {
//		//boolean status = userService.sendContact(email);
//		
//		return "email sent" + email;
//		
//	}
	
	@PostMapping("/contact/{email}")
	public String sendEmail(@PathVariable String email) {
		boolean status = userService.sendContact(email);
		
		return "email sent successfully: " + status;
		
	}
	
	@GetMapping("/hello")
	public String viewEnquiryPage() {
		
		return "Hello";
	}

}
