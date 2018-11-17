package com.topshelf.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topshelf.beans.Fridge;

@Repository
public class FridgeRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public FridgeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Fridge addFridge(Fridge fridge) {
		Session s = sessionFactory.getCurrentSession();
		s.save(fridge);
		return fridge;
	}
	
	
}
