package com.masaischool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	List<Customer> customerList;
	
	public CustomerController() {
		customerList = new ArrayList<>();
	}

	//Endpoint: http://localhost:8080/customers
	//request method: POST
	//{"id": -1, "name": "", "lastPurchaseDate": "2024-01-01", "email": "don't know", "mobile": "my name is khan"}
	@PostMapping(value = "/customers")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		customerList.add(customer);
		return customer;
	}
}
