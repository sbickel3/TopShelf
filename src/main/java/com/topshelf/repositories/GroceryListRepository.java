package com.topshelf.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
@Repository
public class GroceryListRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public GroceryListRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public GroceryList addGroceryList(GroceryList groceryList) {
		Session s = sessionFactory.getCurrentSession();
		groceryList.setIngredient(null);
		s.save(groceryList);
		return groceryList;
	}
}
