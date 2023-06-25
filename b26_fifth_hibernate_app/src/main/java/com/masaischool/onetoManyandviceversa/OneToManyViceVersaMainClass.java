package com.masaischool.onetoManyandviceversa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OneToManyViceVersaMainClass {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("association_mapping");
	}
	
	static void addEmployeeAccountDetails() {
		//Create object of Employee
		Employee employee = new Employee("abc@gmail.com", "ABC", "PQR", new HashSet<Account>());

		//Create some object of Accounts
		Account accOne = new Account();
		accOne.setAccountNumber("A001");
		
		Account accTwo = new Account();
		accTwo.setAccountNumber("A002");
		
		employee.getAccounts().add(accOne);
		employee.getAccounts().add(accTwo);
		
		accOne.setEmployee(employee);
		accTwo.setEmployee(employee);
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(employee);
			//em.persist(accOne);
			//em.persist(accTwo);
			et.commit();			
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
			et.rollback();
		}finally {
			em.close();
		}
	}
	
	static void printEmployeeDetails() {
		try (EntityManager em = emf.createEntityManager();){
			String selectQuery = "FROM Employee e";
			Query query = em.createQuery(selectQuery);
			List<Employee> list = query.getResultList();
			for(Employee emp : list) {
				System.out.println(emp.getFirstName() + ":" + emp.getLastName() + ":" + emp.getEmail());
				
				Set<Account> accountSet = emp.getAccounts();
				for(Account account: accountSet) {
					System.out.println("\tAccount Number: " + account.getAccountNumber());
				}
			}
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void printAccountDetails() {
		try (EntityManager em = emf.createEntityManager();){
			String selectQuery = "FROM Account a";
			Query query = em.createQuery(selectQuery);
			List<Account> list = query.getResultList();
			for(Account account: list) {
				System.out.println(account.getAccountNumber());
				Employee employee = account.getEmployee();
				System.out.println(employee.getFirstName() + ":" + employee.getLastName() + ":" + employee.getEmail());
			}
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//addEmployeeAccountDetails();
		//printEmployeeDetails();
		printAccountDetails();
	}
}
