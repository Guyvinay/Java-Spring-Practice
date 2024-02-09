package com.masaischool.manytomany;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class manytoManyexample {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("association_mapping");
	}
	
	static void saveStudent() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			//Create an object of Student
			Student st = new Student();
			st.setName("ABC");
			st.setEmail("abc@ms.com");
			
			//Create Two Courses
			Course courseOne = new Course();
			courseOne.setCourseName("Java");
			
			Course courseTwo = new Course();
			courseTwo.setCourseName("MEARN");
			
			Set<Course> courseSet = new HashSet<>();
			courseSet.add(courseOne);
			courseSet.add(courseTwo);
			
			st.setCourses(courseSet);	//Student "ABC" is enrolled for both Java & MEARN
			
			Set<Student> studentSet = new HashSet<>();
			studentSet.add(st);
			courseOne.setStudents(studentSet);	//Assigning student ABC to course Java
			courseTwo.setStudents(studentSet);	//Assigning student ABC to course MEARN
			
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(st);
			et.commit();
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void printStudentDetails() {
		try(EntityManager em = emf.createEntityManager();){
			String selectQuery = "FROM Student s";
			Query query = em.createQuery(selectQuery);
			List<Student> list = query.getResultList();
			for(Student s: list) {
				System.out.println(s.getName() + ":" + s.getEmail());
				Set<Course> set = s.getCourses();
				for(Course course: set)
					System.out.println("\t" + course.getCourseName());
			}
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void printCourseDetails() {
		try(EntityManager em = emf.createEntityManager();){
			String selectQuery = "FROM Course s";
			Query query = em.createQuery(selectQuery);
			List<Course> list = query.getResultList();
			for(Course c: list) {
				System.out.println(c.getCourseName());
				Set<Student> set = c.getStudents();
				for(Student st: set)
					System.out.println("\t" + st.getName() + ":" + st.getEmail());
			}
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		saveStudent();
		System.out.println("\n");
		printStudentDetails();
		System.out.println("\n");
		printCourseDetails();
	}
}
