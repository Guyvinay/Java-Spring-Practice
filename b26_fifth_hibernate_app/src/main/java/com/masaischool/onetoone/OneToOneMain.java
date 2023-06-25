package com.masaischool.onetoone;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OneToOneMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("association_mapping");
	}
	
	static void addQuestions() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			Question questionOne = new Question();
			questionOne.setQuestion("What is java?");

			Answer answerOne = new Answer();
			answerOne.setAnswer("It is a portable, object-oriented programming language");
			
			questionOne.setAnswer(answerOne);
			answerOne.setQuestion(questionOne);

			Question questionTwo = new Question();
			questionTwo.setQuestion("What is ORM?");

			Answer answerTwo = new Answer();
			answerTwo.setAnswer("It is the mapping of database table to the programming object");
			
			questionTwo.setAnswer(answerTwo);
			answerTwo.setQuestion(questionTwo);
			
			et = em.getTransaction();
			et.begin();
			em.persist(questionOne);
			em.persist(questionTwo);
			et.commit();
		}catch(IllegalArgumentException | IllegalStateException | PersistenceException ex) {
			System.out.println(ex.getMessage());
			et.rollback();
		}finally {
			em.close();
		}
	}
	
	static void readQuestionAnswer() {
		try(EntityManager em = emf.createEntityManager()){
			String questionQuery = "FROM Question q";
			Query query = em.createQuery(questionQuery);
			List<Question> list = (List<Question>)query.getResultList();
			for(Question question: list) {
				System.out.println(question.getQuestion());
				System.out.println(question.getAnswer());
			}
			
			System.out.println();
			
			String answerQuery = "FROM Answer a";
			Query queryAnswer = em.createQuery(answerQuery);
			List<Answer> listAnswer = queryAnswer.getResultList();
			for(Answer answer: listAnswer) {
				System.out.println(answer.getQuestion().getQuestion());
				System.out.println(answer.getAnswer());
			}
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		addQuestions();
		readQuestionAnswer();
	}
}
