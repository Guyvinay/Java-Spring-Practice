package com.masaischool.joined_table_strategy;

import java.util.List;

import com.masaischool.single_table_strategy.Employee;
import com.masaischool.single_table_strategy.Human;
import com.masaischool.single_table_strategy.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class ScienceStudentMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("inheritance_mapping");
	}
	
	static void addScienceStudents() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();

			//create an object of BioStudent Entity
			BioStudent bioStOne = new BioStudent(78, 76, 85);
			BioStudent bioStTwo = new BioStudent(85, 73, 66);
			
			//create an object of MathStudent Entity
			MathStudent mtOne = new MathStudent(75, 85, 95);
			MathStudent mtTwo = new MathStudent(85, 65, 98);
			
			et = em.getTransaction();
			et.begin();
			em.persist(bioStOne);
			em.persist(bioStTwo);
			em.persist(mtOne);
			em.persist(mtTwo);
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void printStudentDetails() {
		try(EntityManager em = emf.createEntityManager()){
			String allSSQuery = "SELECT s FROM ScienceStudent s";
			Query query = em.createQuery(allSSQuery);
			List<ScienceStudent> ssList = (List<ScienceStudent>)query.getResultList();
			for(ScienceStudent ss: ssList) {
				System.out.print("Id: " + ss.getId() + " Physics: " + ss.getPhysicsMarks() + " Chemistry: " + ss.getChemistryMarks());
				if(ss instanceof BioStudent) {
					//you are here means ss is pointing to object of BioStudent
					BioStudent st = (BioStudent)ss;
					System.out.println(" Bio: " + st.getBioMarks());
				}else {
					//you are here means ss is pointing to object of MathStudent
					MathStudent st = (MathStudent)ss;
					System.out.println(" Maths: " + st.getMathMarks());
				}
			}
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		addScienceStudents();
		printStudentDetails();
		
	}
}
