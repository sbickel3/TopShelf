package com.topshelf.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.CookBook;

@Repository
public class CookBookRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public CookBookRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void addCookbookEntry(CookBook cookbook) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cookbook);
	}
}
