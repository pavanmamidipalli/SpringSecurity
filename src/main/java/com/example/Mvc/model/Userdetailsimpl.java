package com.example.Mvc.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Userdetailsimpl implements UserDetails {
	
    private Security sec;
	public Userdetailsimpl(Security sec) {
		this.sec=sec;
		
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("sec"));
	}

	@Override
	public String getPassword() {
		
		return sec.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return sec.getUsername();
	}

}
