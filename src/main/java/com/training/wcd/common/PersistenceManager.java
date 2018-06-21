package com.training.wcd.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
	private static EntityManagerFactory emf;
	
	public static synchronized EntityManagerFactory retrieveEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("wcd");
		}
		
		return emf;
	}

}
