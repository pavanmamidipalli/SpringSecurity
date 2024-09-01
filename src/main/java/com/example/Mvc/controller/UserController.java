package com.example.Mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mvc.model.Security;
import com.example.Mvc.service.UserService;

@RestController
public class UserController {
	@Autowired
   private UserService userservice;
	@PostMapping("/register")
	public Security save(@RequestBody Security sec) {
		return userservice.add(sec);
		
	}
}
