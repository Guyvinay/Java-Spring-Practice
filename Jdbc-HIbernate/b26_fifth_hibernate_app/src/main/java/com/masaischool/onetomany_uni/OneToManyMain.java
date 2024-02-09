package com.masaischool.onetomany_uni;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OneToManyMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("association_mapping");
	}
	
	static void saveCarCompanyDetails() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		//Create some object of Category
		CarCompany cc = new CarCompany();
		cc.setCompanyName("TATA");
			
		//Create object of Product
		CarModel cmOne= new CarModel();
		cmOne.setModelNo("NEXON");
		cmOne.setPriceInLPA(10.00);
		
		//Create object of Product
		CarModel cmTwo= new CarModel();
		cmTwo.setModelNo("HARRIAR");
		cmTwo.setPriceInLPA(17.00);
		
		try {
			em = emf.createEntityManager();
			Set<CarModel> set = new HashSet<>();
			set.add(cmOne);
			set.add(cmTwo);
			cc.setModels(set);
			
			et = em.getTransaction();
			et.begin();
			em.persist(cc);
			et.commit();
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
			et.rollback();
		}finally {
			em.close();
		}
		
	}
	
	static void printCarCompanyDetails() {
		try(EntityManager em = emf.createEntityManager()){
			String selectQuery = "FROM CarCompany cc";
			Query query = em.createQuery(selectQuery);
			List<CarCompany> list = query.getResultList();
			for(CarCompany cc: list) {
				System.out.println(cc.getCompanyName());
				Set<CarModel> set = cc.getModels();
				for(CarModel cm: set)
					System.out.println("\t" + cm.getModelNo() + ":" + cm.getPriceInLPA());
			}
			
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			selectQuery = "FROM CarModel a";
			query = em.createQuery(selectQuery);
			List<CarModel> catList = query.getResultList();
			for(CarModel cm: catList) {
				System.out.println(cm.getModelNo() + ":" + cm.getPriceInLPA());
				//No way to access the CarCompany for CarModel
			}			
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		saveCarCompanyDetails();
		printCarCompanyDetails();
	}
}
