package com.masaischool.onetoManyandviceversa;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {//owning side
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;

	//Insert code here such that
	//One Account can belong to One Employee only
	//we have to use @JoinTable on the owning side,
	//here the name attribute is used to define name of foreign key column
	//fetch = FetchType.LAZY will enable the lazy loading for ManyToOne also
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(long id, String accountNumber, Employee employee) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		return true;
	}
}