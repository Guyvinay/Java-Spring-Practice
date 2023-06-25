package com.masaischool.manytoone_uni;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ManyToOneMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("association_mapping");
	}
	
	static void saveProductDetails() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		//Create some object of Category
		Category catOne = new Category();
		catOne.setCategoryName("Furniture");
			
		//Create object of Product
		Product productOne = new Product();
		productOne.setName("Table");
		productOne.setPrice(1499.00);
		productOne.setCategory(catOne);
		
		Product productTwo = new Product();
		productTwo.setName("Chair");
		productTwo.setPrice(999.00);
		productTwo.setCategory(catOne);
		
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(catOne);
			em.persist(productOne);
			em.persist(productTwo);
			et.commit();
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
			et.rollback();
		}finally {
			em.close();
		}
	}
	
	static void printProductDetails() {
		try(EntityManager em = emf.createEntityManager()){
			String selectQuery = "FROM Product a";
			Query query = em.createQuery(selectQuery);
			List<Product> list = query.getResultList();
			for(Product product: list) {
				System.out.println(product.getName() + ":" + product.getPrice() + ":" + product.getCategory().getCategoryName());
			}
			
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			selectQuery = "FROM Category a";
			query = em.createQuery(selectQuery);
			List<Category> catList = query.getResultList();
			for(Category cat: catList) {
				System.out.println(cat.getCategoryName());
				//No way to access the Product for category
			}			
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		saveProductDetails();
		printProductDetails();
	}
}
