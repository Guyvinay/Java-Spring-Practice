package com.spring.service;

import java.util.List;

import com.spring.exception.CustomerException;
import com.spring.modal.Customer;

public interface CustomerService {

    public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;
	
}
