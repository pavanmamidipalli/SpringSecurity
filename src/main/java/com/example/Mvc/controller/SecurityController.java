package com.example.Mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mvc.Entity.Details;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	@GetMapping("/hello")
	public String display(HttpServletRequest httServletRequest) {
		return "welcome to Spring boot security "+httServletRequest.getSession().getId();
	}
	List<Details> details = new ArrayList<>(List.of(new Details(1,"pavan","gdk"),new Details(2,"hello","hyd"),new Details(3,"hi","hmk")));
	@GetMapping("/showme")
	public List<Details> show() {
		return details;
	}
	@PostMapping("/hi")
	public void add(@RequestBody Details detail ) {
		details.add(detail);
		
	}
	@GetMapping("/csrfTokens")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}

}
