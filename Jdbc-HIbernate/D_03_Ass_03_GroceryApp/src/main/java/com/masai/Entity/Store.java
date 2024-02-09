package com.masai.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

/*
 * store_id
store_name
location
 */

@Entity
public class Store {//inverse side;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int store_id;
	private String store_name;
	private String location;
	
	@ManyToMany(mappedBy = "stores")
	private Set<Buyer> buyers;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(String store_name, String location) {
		super();
		this.store_name = store_name;
		this.location = location;
		
	}
	

	public Store(String store_name, String location, Set<Buyer> buyers, Seller seller) {
		super();
		this.store_name = store_name;
		this.location = location;
		this.buyers = buyers;
		this.seller = seller;
	}


	public String getStore_name() {
		return store_name;
	}


	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Set<Buyer> getBuyers() {
		return buyers;
	}


	public void setBuyers(Set<Buyer> buyers) {
		this.buyers = buyers;
	}


	public Seller getseller() {
		return seller;
	}


	public void setseller(Seller seller) {
		this.seller = seller;
	}


	public int getStore_id() {
		return store_id;
	}
	
	
}
