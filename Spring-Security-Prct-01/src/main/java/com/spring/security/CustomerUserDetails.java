package com.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.modal.Customer;

public class CustomerUserDetails implements UserDetails {

	private Customer customer;
	
	CustomerUserDetails(Customer customer){
		this.customer=customer;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  List<GrantedAuthority> auth = new ArrayList<>();
		return auth;
	}

	@Override
	public String getPassword() {
		  
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		  
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		  
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		  
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		  
		return true;
	}

	@Override
	public boolean isEnabled() {
		  
		return true;
	}

}
