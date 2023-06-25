package com.masaischool.single_table_strategy;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class HumanMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("inheritance_mapping");
	}
	
	static void addEmployeeAndStudent() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();

			//create an object of Employee Entity
			Employee empOne = new Employee("ABC", 65.25, 9.6, "ABC Company");
			Employee empTwo = new Employee("XYZ", 45.25, 9.6, "XYZ Company");
			
			//create an object of Student Entity
			Student stOne = new Student("BCD", 48.25, "Java", "Masai");
			Student stTwo = new Student("YZA", 45.63, "React", "Masai");
			
			et = em.getTransaction();
			et.begin();
			em.persist(empOne);
			em.persist(empTwo);
			em.persist(stOne);
			em.persist(stTwo);
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void printHumanDetails() {
		try(EntityManager em = emf.createEntityManager()){
			String allHumanQuery = "SELECT h FROM Human h";
			Query query = em.createQuery(allHumanQuery);
			List<Human> humanList = (List<Human>)query.getResultList();
			for(Human h: humanList) {
				System.out.print("Id: " + h.getId() + " Name: " + h.getName() + " Weight: " + h.getWeight());
				if(h instanceof Student) {
					//you are here means h is pointing to object of Student
					Student st = (Student)h;
					System.out.println(" Course: " + st.getCourse() + " Institution Name: " + st.getInstitutionName());
				}else {
					//you are here means h is pointing to object of Employee
					Employee emp = (Employee)h;
					System.out.println(" Salary: " + emp.getSalary() + " Organization Name: " + emp.getOrganizationName());
				}
			}
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		addEmployeeAndStudent();
		printHumanDetails();
	}
}
