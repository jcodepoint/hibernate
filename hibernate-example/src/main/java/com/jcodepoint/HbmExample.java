package com.jcodepoint;

import java.util.List;

import com.jcodepoint.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Hibernate introductory example
 *
 */
public class HbmExample {
    public static void main( String[] args ) {
    	
		EntityManagerFactory emf = null;
		
		EntityManager entityManager = null;
        
		try {
			
			emf = Persistence.createEntityManagerFactory("standalone-sample");
			
			entityManager = emf.createEntityManager();
			
			TypedQuery<Customer> q = entityManager.createQuery("select c from customer c", Customer.class);
			
			List<Customer> resultList = q.getResultList();
			
			System.out.println("-> Customers count: " + resultList.size());
			
			for (Customer next : resultList) {
				
				System.out.println("-> " + next.toString());
				
			}
			
		} catch(Exception e) {
			
		}
    }
}
