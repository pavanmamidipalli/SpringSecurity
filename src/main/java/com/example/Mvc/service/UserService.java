package com.example.Mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Mvc.model.Security;
import com.example.Mvc.repo.UserRepo;

@Service
public class UserService {
 @Autowired
 private UserRepo repo;
 private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
 public Security add(Security sec) {
	 sec.setPassword(encoder.encode(sec.getPassword()));
	 return repo.save(sec); 
 }
}
