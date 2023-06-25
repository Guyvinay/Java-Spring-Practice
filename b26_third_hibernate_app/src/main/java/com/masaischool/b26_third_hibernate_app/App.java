package com.masaischool.b26_third_hibernate_app;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class App {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my_employee");
	}
	
	static void printEmployeeNameInUpperCase() {
		try(EntityManager em = emf.createEntityManager()){
			//Native SQL: SELECT UPPER(emp_name) FROM my_employee;
			//JPQL: SELECT UPPER(e.name) FROM Employee e
			String upperQuery = "SELECT UPPER(e.name) FROM Employee e";
			Query query = em.createQuery(upperQuery);
			List<String> list = (List<String>)query.getResultList();
			for(String name: list) {
				System.out.print(name + " ");
			}			
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void printMaximumSalary() {
		try(EntityManager em = emf.createEntityManager()){
			//Native SQL: SELECT max(salary) FROM my_employee;
			//JPQL: SELECT MAX(e.salary) FROM Employee e
			String maxQuery = "SELECT MAX(e.salary) FROM Employee e";
			Query query = em.createQuery(maxQuery);
			Integer maxSalary = (Integer)query.getSingleResult();
			System.out.print("The maximum salary is " + maxSalary);				
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void printEmployeeDetailsForSalaryRange(int start, int end) {
		try(EntityManager em = emf.createEntityManager()){
			//Native SQL: SELECT * FROM my_employee WHERE salary BETWEEN <start> AND <end>;
			//JPQL: SELECT e FROM Employee e WHERE e.salary BETWEEN :lower_range AND :upper_range
			String maxQuery = "SELECT e FROM Employee e WHERE e.salary BETWEEN :lower_range AND :upper_range";
			Query query = em.createQuery(maxQuery);
			query.setParameter("lower_range", start);
			query.setParameter("upper_range", end);
			List<Employee> employeeList = (List<Employee>)query.getResultList();
			for(Employee emp: employeeList)
				System.out.println(emp);
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static void printEmployeeCountDesignationWise() {
		try(EntityManager em = emf.createEntityManager()){
			//Native SQL: SELECT designation, COUNT(*) FROM my_employee GROUP BY designation HAVING COUNT(*) >= 2 ORDER BY COUNT(*) DESC;
			//JPQL: SELECT e.designation, COUNT(e) FROM Employee e GROUP BY e.designation HAVING COUNT(e) >= 2 ORDER BY COUNT(e) DESC
			String maxQuery = "SELECT e.designation, COUNT(e) FROM Employee e GROUP BY e.designation HAVING COUNT(e) >= 2 ORDER BY COUNT(e) DESC";
			Query query = em.createQuery(maxQuery);
			List<Object[]> employeeList = (List<Object[]>)query.getResultList();
			for(Object[] emp: employeeList)
				System.out.println("Designation: " + emp[0] + " Total employee " + emp[1]);
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void promoteEmployee() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();
			//Native SQL: UPDATE my_employee SET designation = "Sr. Clerk", salary = 35000 WHERE id = 1207"
			//JPQL: UPDATE Employee SET designation = :designation, salary = :salary WHERE id = :id
			String maxQuery = "UPDATE Employee SET designation = :designation, salary = :salary WHERE id = :id";
			Query query = em.createQuery(maxQuery);
			query.setParameter("designation", "Sr. Clerk");
			query.setParameter("salary", 35000);
			query.setParameter("id", 1207);
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void deleteEmployeeById() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();
			//Native SQL: DELETE FROM my_employee WHERE id = 1207"
			//JPQL: DELETE FROM Employee WHERE id = :id
			String maxQuery = "DELETE FROM Employee WHERE id = :id";
			Query query = em.createQuery(maxQuery);
			query.setParameter("id", 1207);
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void printEmployeeByDesignation() {
		try(EntityManager em = emf.createEntityManager()){
			//FindEmployeeByDesignation = SELECT e FROM Employee e WHERE e.designation IN(:designation)
			Query query = em.createNamedQuery("FindEmployeeByDesignation", Employee.class);
			List<String> designationList = new ArrayList<>();
			designationList.add("Technical Writer");
			designationList.add("Proof Reader");
			query.setParameter("designation", designationList);
			List<Employee> employeeList = (List<Employee>)query.getResultList();
			for(Employee emp: employeeList)
				System.out.println(emp);
		}catch(IllegalStateException | IllegalArgumentException ex) {
			//System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	static void printEmployeeDetailsForNamePattern() {
		try(EntityManager em = emf.createEntityManager()){
			Query query = em.createNamedQuery("FindEmployeeByNamePattern", Employee.class);
			query.setParameter("name", "%r%");
			List<Employee> employeeList = (List<Employee>)query.getResultList();
			for(Employee emp: employeeList)
				System.out.println(emp);
		}catch(IllegalStateException | IllegalArgumentException ex) {
			//System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	static void printAllEmployeeDetails() {
		try(EntityManager em = emf.createEntityManager()){
			Query query = em.createNamedQuery("FindAllEmployees");
			List<Object[]> employeeList = (List<Object[]>)query.getResultList();
			for(Object o[]: employeeList)
				System.out.println(o[0] + ", " + o[1] + ", " + o[2]+ ", " + o[3] + ", " + o[4]);
		}catch(IllegalStateException | IllegalArgumentException ex) {
			//System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
    public static void main(String[] args){
    	printEmployeeNameInUpperCase();
    	System.out.println("\n");
    	printMaximumSalary();
    	System.out.println("\n");
    	printEmployeeDetailsForSalaryRange(35000, 40000);
    	System.out.println("\n");
    	printEmployeeCountDesignationWise();
    	System.out.println("\n");
    	promoteEmployee();
    	System.out.println("\n");
    	deleteEmployeeById();
    	System.out.println("\n");
    	printEmployeeDetailsForNamePattern();
    	System.out.println("\n");
    	printAllEmployeeDetails();
    	System.out.println("\n");
    	printEmployeeByDesignation();
    }
}
