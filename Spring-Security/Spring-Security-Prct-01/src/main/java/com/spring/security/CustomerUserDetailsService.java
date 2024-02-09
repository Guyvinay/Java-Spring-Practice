package com.spring.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.exception.CustomerException;
import com.spring.modal.Customer;
import com.spring.repository.CustomerRepo;

public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired private CustomerRepo customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Customer> optional = customerRepo.findByEmail(username);
		
		if(optional.isPresent()) {
			Customer customer = optional.get();
			List<GrantedAuthority> authority = new ArrayList<>();
			return new User(customer.getEmail() , customer.getPassword() , authority);
//			return new CustomerUserDetails(customer);
		}else {
			throw new CustomerException("Customer not found");
		}
	}

}
