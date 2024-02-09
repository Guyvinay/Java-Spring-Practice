package com.masai.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/*
 * seller_id
seller_name
year_of_experience
email
 */
@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seller_id;
	private String seller_name;
	private int years_of_exp;
	private String email;
	
	@OneToMany(mappedBy = "seller" , cascade = CascadeType.ALL)
	private Set<Store> store;
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(String seller_name, int years_of_exp, String email, Set<Store> store) {
		super();
		this.seller_name = seller_name;
		this.years_of_exp = years_of_exp;
		this.email = email;
		this.store = store;
	}

	public String getSeller_name() {
		return seller_name;
	}

	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}

	public int getYears_of_exp() {
		return years_of_exp;
	}

	public void setYears_of_exp(int years_of_exp) {
		this.years_of_exp = years_of_exp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Store> getStore() {
		return store;
	}

	public void setStore(Set<Store> store) {
		this.store = store;
	}

	public int getSeller_id() {
		return seller_id;
	}
	
	
	
	
}
