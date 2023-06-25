package com.masaischool.table_per_class;

import java.util.List;

import com.masaischool.joined_table_strategy.BioStudent;
import com.masaischool.joined_table_strategy.MathStudent;
import com.masaischool.joined_table_strategy.ScienceStudent;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ElectricityConnectionMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("inheritance_mapping");
	}
	
	static void addElectricityConnections() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();

			CommercialElectricityConnection commOne = new CommercialElectricityConnection(1, 200, 10.0, 8.0, 200.0);
			CommercialElectricityConnection commTwo = new CommercialElectricityConnection(2, 300, 9.0, 9.0, 250.0);
			
			DomesticElectricityConnection domOne = new DomesticElectricityConnection(3, 250, 6.0, 150.0);
			DomesticElectricityConnection domTwo = new DomesticElectricityConnection(4, 350, 7.5, 175.0);
			
			et = em.getTransaction();
			et.begin();
			em.persist(commOne);
			em.persist(commTwo);
			em.persist(domOne);
			em.persist(domTwo);
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void printElectricityConnectionDetails() {
		try(EntityManager em = emf.createEntityManager()){
			String allECQuery = "SELECT ec FROM ElectricityConnection ec";
			Query query = em.createQuery(allECQuery);
			List<ElectricityConnection> ecList = (List<ElectricityConnection>)query.getResultList();
			for(ElectricityConnection ec: ecList) {
				System.out.print("Id: " + ec.getId() + " Unit Consumed: " + ec.getUnitConsumed() + " Unit Charges: " + ec.getUnitCharges());
				if(ec instanceof CommercialElectricityConnection) {
					CommercialElectricityConnection st = (CommercialElectricityConnection)ec;
					System.out.println(" Value Added Tax: " + st.getValueAddedTax() + " Fixed Charges" + st.getFixCharge());
				}else {
					DomesticElectricityConnection st = (DomesticElectricityConnection)ec;
					System.out.println(" Electricity Duty: " + st.getElectricityDuty());
				}
			}
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		addElectricityConnections();
		printElectricityConnectionDetails();
	}
}
