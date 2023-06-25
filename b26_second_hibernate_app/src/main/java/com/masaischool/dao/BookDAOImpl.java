package com.masaischool.dao;

import java.math.BigDecimal;

import com.masaischool.entity.Book;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class BookDAOImpl implements BookDAO {
	@Override
	public void addBook(Book book) throws SomethingWentWrongException {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			//Life-Cycle phase: Transient
			em.persist(book);	//Life-Cycle phase: Managed
			et.commit();
		}catch(PersistenceException ex) {
			et.rollback();
			//ex.printStackTrace();
			throw new SomethingWentWrongException("Unable to add book, try again later");
		}finally {
			em.close();
			//Life-Cycle phase: Detached
		}
	}

	@Override
	public Book getBookById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		Book book = null;
		//can we use try with resources here: yes
		try(EntityManager em = EMUtils.getEntityManager()){
			book = em.find(Book.class, id);
			//Life-Cycle phase: managed
			if(book == null) {
				throw new NoRecordFoundException("No book available for given id");
			}
		}catch(IllegalArgumentException ex) {
			throw new SomethingWentWrongException("Unable to fetch book details, please try again later");
		}
		//Life-Cycle phase: detached
		return book;
	}

	@Override
	public void updateBookPrice(int id, BigDecimal price) throws SomethingWentWrongException, NoRecordFoundException {
		Book book = getBookById(id);
		//Life-Cycle phase: detached
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			book = em.merge(book);	//Life-Cycle phase: Managed
			book.setPrice(price);
			//Update operation will be executed by book hibernate
			et.commit();
		}catch(PersistenceException ex) {
			et.rollback();
			//ex.printStackTrace();
			throw new SomethingWentWrongException("Unable to add book, try again later");
		}finally {
			em.close();
			//Life-Cycle phase: Detached
		}
	}

	@Override
	public void deleteBookById(int id) throws SomethingWentWrongException, NoRecordFoundException {
		Book book = getBookById(id);
		//Life-Cycle phase: detached
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			
			//merged method returns an entity which is in the managed state
			book = em.merge(book);	//Life-Cycle phase: managed
			em.remove(book);	//Life-Cycle phase: removed
			et.commit();
		}catch(PersistenceException ex) {
			et.rollback();
			ex.printStackTrace();
			throw new SomethingWentWrongException("Unable to delete book, try again later");
		}finally {
			em.close();
		}
	}
	
//	@Override
//	public void deleteBookById(int id) throws SomethingWentWrongException, NoRecordFoundException {
//		EntityManager em = null;
//		EntityTransaction et = null;
//		Book book = null;
//		try {
//			em = EMUtils.getEntityManager();
//			book = em.find(Book.class, id);	//Life-Cycle phase: Managed
//			et = em.getTransaction();
//			et.begin();
//			em.remove(book);	//Life-Cycle phase: removed
//			et.commit();
//		}catch(PersistenceException ex) {
//			et.rollback();
//			ex.printStackTrace();
//			throw new SomethingWentWrongException("Unable to delete book, try again later");
//		}finally {
//			em.close();
//		}
//	}
}
