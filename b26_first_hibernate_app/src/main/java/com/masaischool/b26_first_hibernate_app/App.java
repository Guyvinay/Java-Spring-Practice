package com.masaischool.b26_first_hibernate_app;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class App {
	static EntityManagerFactory entityManagerFactory = null;
	
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("abc");	//--(1)
	}
	
	static void insertStudent(Student student) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();	//--(2)
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			System.out.println("Student added successfully");
		}catch(PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		}finally {
			entityManager.close();	//--(3)			
		}
	}
	
	static void readStudentByRollNo(int roll) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();	//--(2)
        Student student = entityManager.find(Student.class, 10);
        if(student == null) {
        	System.out.println("No student found with given roll number");
        }else {
            System.out.println(student);		        	
        }
		entityManager.close();	//--(3)
	}
	
	static void updateStudentNameByRollNo(int roll, String name) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();	//--(2)
			Student student = entityManager.find(Student.class, roll);	//The Entity object is derived from the databsse record
			if(student == null) {
				System.out.println("Invalid roll number");
				return;
			}
			//database record and the fetched entity is in the synchronization so any changes
			//in the entity will be reflected to the database
			
			//you are here means student exists with given roll number
			transaction = entityManager.getTransaction();
			transaction.begin();
			student.setName(name);
			transaction.commit();
			System.out.println("Student updated successfully");
		}catch(PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		}finally {
			entityManager.close();	//--(3)			
		}
	}
	
	static void deleteStudent(int roll) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();	//--(2)
			Student student = entityManager.find(Student.class, roll);
			if(student == null) {
				System.out.println("Invalid roll number");
				return;
			}
			//you are here means student exists with given roll number
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(student);
			transaction.commit();
			System.out.println("Student deleted successfully");
		}catch(PersistenceException pe) {
			System.out.println(pe.getMessage());
			transaction.rollback();
		}finally {
			entityManager.close();	//--(3)			
		}
	}
	
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
        	System.out.println("1. Insert operation");
        	System.out.println("2. View Student by roll number");
        	System.out.println("3. Update student name by roll number");
        	System.out.println("4. Delete by roll number");
        	System.out.println("0. Exit");
        	System.out.print("Enter selection ");
        	choice = sc.nextInt();
        	switch(choice) {
        		case 1:
        			System.out.print("Enter roll number ");
        	        int rollNo = sc.nextInt();
        	        System.out.print("Enter name ");
        	        String name = sc.next();
        	        System.out.print("Enter marks ");
        	        int marks = sc.nextInt();
        			Student st = new Student(rollNo, name, marks);
        			insertStudent(st);
        			break;
        		case 2:
        	        System.out.print("Enter roll number ");
        	        rollNo = sc.nextInt();
        	        readStudentByRollNo(rollNo);
        	        break;
        		case 3:
        	        System.out.print("Enter roll number ");
        	        rollNo = sc.nextInt();
        	        name = sc.next();
        	        updateStudentNameByRollNo(rollNo, name);
        	        break;
        		case 4:
        	        System.out.print("Enter roll number ");
        	        rollNo = sc.nextInt();
        	        deleteStudent(rollNo);
        	        break;
        		case 0:
        			System.out.println("bye Bye");
        			break;
        		default:
        			System.out.println("Invalid selection, try again");
        	}
        }while(choice != 0);
        sc.close();
    }
}
