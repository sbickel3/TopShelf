package com.topshelf.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
@Repository
public class GroceryListRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public GroceryListRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public GroceryList addGroceryList(GroceryList groceryList) {
		Session s = sessionFactory.getCurrentSession();
		s.save(groceryList);
		return groceryList;
	}
}
