package com.masaischool;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Customer {
	@NotNull(message = "Customer id is mandatory")
	@Min(value = 1, message = "{customer.id.error}")
	//is same as
	//@Positive(message = "Customer id must be a positive number")
	private Integer id;
	
	@NotNull(message = "Customer name is mandatory")
	@Size(min = 2, max = 15, message = "Length of name must be from 2 - 15 characters")
	private String name;
	
	@PastOrPresent(message = "Last purchase date cannot be of future")
	private LocalDate lastPurchaseDate;
	
	@NotNull(message = "Customer email is mandatory")
	@Email(regexp = "[a-z0-9._]+@[a-z0-9._]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "Email must be in a valid format")
	private String email;
	
	@NotNull(message = "Customer mobile number is mandatory")
	@Pattern(regexp = "^[6-9][0-9]{9}", message = "Please provide a valid mobile number")
	
	/**
	 * @NotNull: null(X) Empty(Y)
	 * @NotEmpty: null(X) Empty(X) length of string must be more than zero (untrimmed)
	 * @NotBlank: null(X) Empty(X) length of trimmed string must be more than zero
	 */
	private String mobile;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id, String name, LocalDate lastPurchaseDate, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.lastPurchaseDate = lastPurchaseDate;
		this.email = email;
		this.mobile = mobile;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(LocalDate lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
