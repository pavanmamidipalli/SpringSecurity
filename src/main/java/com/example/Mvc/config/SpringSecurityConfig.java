package com.example.Mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean
	public SecurityFilterChain cofig(HttpSecurity http) throws Exception {
//		for csrf token
//		Customizer<CsrfConfigurer<HttpSecurity>> cs = new Customizer<CsrfConfigurer<HttpSecurity>>(){
//
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> t) {
//				t.disable();
//				
//				
//			}
//			
//		};
//		  for authenticate
//		Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> cust=new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//        
//			@Override
//			public void customize(
//				AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry t) {
//		t.anyRequest().authenticated();
//				
//			}			
//		};
		http.csrf(customizer->customizer.disable());
		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
		//http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
		
//		@Bean
//	    public UserDetailsService userDetailsService() {
//			UserDetails user = User.withDefaultPasswordEncoder().username("hi").password("321").roles("user").build();
//			UserDetails admin = User.withDefaultPasswordEncoder().username("go").password("123").roles("admin").build();
//			return new InMemoryUserDetailsManager(user,admin);
//		
//	}
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	
	public AuthenticationProvider authprovider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		return provider;
		
		
	}

}
