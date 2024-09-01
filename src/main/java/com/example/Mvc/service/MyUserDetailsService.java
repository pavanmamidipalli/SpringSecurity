package com.example.Mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Mvc.model.Security;
import com.example.Mvc.model.Userdetailsimpl;
import com.example.Mvc.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Security sec =repo.findByUsername(username);
		if(sec==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("exception");
		}
		return new Userdetailsimpl(sec);
	}

}
