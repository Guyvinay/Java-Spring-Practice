package com.masaischool.mapped_super_class;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class LoanMain {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("inheritance_mapping");
	}
	
	static void addLoans() {
		EntityManager em = null;
		EntityTransaction et = null;
		try{
			em = emf.createEntityManager();

			HomeLoan hlOne = new HomeLoan(500000.0, 10.0, 9.25, 7.5, 75000.0);
			HomeLoan hlTwo = new HomeLoan(750000.0, 20.0, 7.90, 7.5, 125000.0);
			
			PersonalLoan plOne = new PersonalLoan(450000.0, 5.0, 11.25, 4500.0, 1250.0);
			PersonalLoan plTwo = new PersonalLoan(550000.0, 4.5, 10.20, 6500.0, 0.0);
			
			et = em.getTransaction();
			et.begin();
			em.persist(hlOne);
			em.persist(hlTwo);
			em.persist(plOne);
			em.persist(plTwo);
			et.commit();
		}catch(IllegalStateException | IllegalArgumentException | PersistenceException ex) {
			et.rollback();
			System.out.println(ex.getMessage());
		}finally {
			em.close();
		}
	}
	//in real life how we are going to decide we are going to use single, joined, table or mapped strategy.

	static void printLoanDetails() {
		try(EntityManager em = emf.createEntityManager()){
			//because the Loan class not an entity class so we cannot use the same in JPQL
			//Solution: use FQCN (Fully Qualified Class Name)
			String allLoanQuery = "FROM com.masaischool.mapped_super_class.Loan";
			Query query = em.createQuery(allLoanQuery);
			List<Loan> loanList = (List<Loan>)query.getResultList();
			for(Loan loan: loanList) {
				System.out.print("Id: " + loan.getId() + " Principle Amount: " + loan.getPrincipleAmount() + 
						" Interest Rate: " + loan.getInterestRate() + " Time Period: " + loan.getTimePeriod());
				if(loan instanceof HomeLoan) {
					HomeLoan hl = (HomeLoan)loan;
					System.out.println(" Stamp Duty: " + hl.getStampDuty() + " Subsidy Amount" + hl.getSubsidyAmount());
				}else {
					PersonalLoan pl = (PersonalLoan)loan;
					System.out.println(" Processing Fee: " + pl.getProcessingFee() + " Add on taxes: " + pl.getAddOnTaxes());
				}
			}
		}catch(IllegalStateException | IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		addLoans();
		printLoanDetails();
	}
}
