package com.spring.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.exception.CustomerException;
import com.spring.modal.Customer;
import com.spring.repository.CustomerRepo;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired CustomerRepo customerRepo;
	
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		Optional<Customer> optional = customerRepo.findByEmail(username);
		if(optional.isEmpty()) {
			throw new CustomerException("Customer not found");
		}else {
			Customer customer = optional.get();
			if(passwordEncoder.matches(password, customer.getPassword())){
				List<GrantedAuthority> auth = new ArrayList<>();
				return new UsernamePasswordAuthenticationToken(username, password, auth);
			}else {
				throw new CustomerException("Wrong Creds Entered");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
