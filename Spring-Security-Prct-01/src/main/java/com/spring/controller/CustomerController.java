package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.modal.Customer;
import com.spring.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired private CustomerService customerService;
	
	@Autowired private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer) , HttpStatus.ACCEPTED);
	}
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmailHandler(@PathVariable("email") String email){
		Customer customer= customerService.getCustomerDetailsByEmail(email);
		return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler(){
		List<Customer> customers= customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);
		
	}
	@GetMapping(value = "/login")
	public ResponseEntity<String> loginMethod(Authentication auth){
		System.out.println(auth);
		Customer customer = customerService.getCustomerDetailsByEmail(auth.getName());
		return new ResponseEntity<String>(customer.getName()+"Logged-in successfully" , HttpStatus.OK);
	}
	
}
