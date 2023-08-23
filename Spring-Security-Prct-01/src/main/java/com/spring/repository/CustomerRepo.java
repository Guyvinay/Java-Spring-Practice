package com.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.modal.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Optional<Customer> findByEmail(String email);
}
