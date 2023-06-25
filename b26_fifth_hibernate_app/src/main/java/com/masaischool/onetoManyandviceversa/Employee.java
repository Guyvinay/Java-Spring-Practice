package com.masaischool.onetoManyandviceversa;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {//referencing/inverse side
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String email;
	private String firstName;
	private String lastName;
	
	//The mappedBy attribute contains the name of the association-field on the owning side 
	//and the mappedBy must be used at the inverse side
	//cascade = CascadeType.ALL
	//1. When Employee is saved then account will also be saved
	//2. When Employee is updated then account will also be updated
	//3. When Employee is deleted then account will also be deleted
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<Account> accounts;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String email, String firstName, String lastName, Set<Account> accounts) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accounts = accounts;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
}
