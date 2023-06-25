package com.masai.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

public class Main {

static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("masaiUnit");
	}
	
	
	public static void addStore() {
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
		em = emf.createEntityManager();
			et = em.getTransaction();
			
			ApplicationContext apc = new ClassPathXmlApplicationContext("applicationContext.xml");
			Store store = apc.getBean(Store.class , "store");
			
//			Store store = new Store("store3"  , "loc3");
			
			et.begin();
			em.persist(store);
			et.commit();
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	public static void registerBuyer(int id) {
		
		
		
	}
	
	public static void main(String[] args) {
		
		addStore();
	}
	
}
