package com.masai.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/*
 * 
 * buyer_id
name
email
mobile
 * 
 */
@Entity
public class Buyer {//owning side

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int buyer_id;
	private String name;
	private String email;
	private int mobile;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Buyer_store" , 
	           joinColumns = {@JoinColumn(name= "buyer_id")},
	           inverseJoinColumns = {@JoinColumn(name = "store_id")}
			)
	private Set<Store> stores;
	
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(String name, String email, int mobile, Set<Store> stores) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.stores = stores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	public int getBuyer_id() {
		return buyer_id;
	}
	
	
}
