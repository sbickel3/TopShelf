package com.topshelf.repositories;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;

@Repository
public class ChefRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public ChefRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Chef getChefById(int id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Chef.class, id);
	}
	
	public Chef insertNewChef(Chef newChef) {
		Session s = sessionFactory.getCurrentSession();
		Query createNewChef = s.createQuery("from Chef where Chef.username = ? or Chef.email = ?");
		createNewChef.setParameter(0, newChef.getUsername());
		createNewChef.setParameter(1, newChef.getEmail());
		List<Chef> newUserResult = createNewChef.getResultList();
		if (newUserResult.size() > 0) {
			return null;
		}
		s.save(newChef);
		return newChef;
	}
	
	public Chef getChefByUsername(String username) {
		Session s = sessionFactory.getCurrentSession();
		Query queryChef = s.createQuery("from Chef where Chef.username = ?");
		queryChef.setParameter(0, username);
		List<Chef> desiredChef = queryChef.getResultList();
		return desiredChef.get(0);
	}
	
	public Chef login(String username, String password) {
		Session s = sessionFactory.getCurrentSession();
		Query queryChef = s.createQuery("from Chef where Chef.username = ? and Chef.password = ?");
		queryChef.setParameter(0, username);
		queryChef.setParameter(1, password);
		List<Chef> queryResult = queryChef.getResultList();
		if (queryResult.size() == 0) {
			return null;
		}else {
			Chef loggedInChef = queryResult.get(0);
			return loggedInChef;
		}
	}
	
	/*@Override
	public void insertNewChef(String firstname, String lastname, String email, String username, String password, Blob fridge_ingredients, Blob grocery_ingredients) {
		// retrieve the session from the Session Factory
		Session session = factory.getCurrentSession();
		try {
			// create a Chef object, including objects its reference with (Fridge & GroceryList)
			Fridge fridge = new Fridge(fridge_ingredients);
			GroceryList grocery = new GroceryList(grocery_ingredients);
			Chef chef = new Chef(firstname,lastname,email,username,password, fridge, grocery);
			
			// start the transaction
			session.beginTransaction(); 
			
			// persist the chef object into the DB
			session.save(chef);
			
			// commit the transaction 
			session.getTransaction().commit();
			
		} catch(Throwable e) { // will catch all errors and exceptions
			e.printStackTrace();
			
			// rollback to state before transaction started
			session.getTransaction().rollback();
		} finally {
			// always close the session
			session.close(); 
		}
	}*/
	
	
	/*
	// create a session factory 
	private SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Chef.class)
			.addAnnotatedClass(Fridge.class)
			.addAnnotatedClass(GroceryList.class)
			.buildSessionFactory();
	
	@Override
	public SessionFactory getSessionFactory() {
		return factory; 
	}
	
	@Override
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Chef getChefById(int id) {
		// create a Chef object
		Chef chef = null;
		
		// retrieve the session from the Session Factory
		Session session = factory.getCurrentSession();
		try {
			// start the transaction
			session.beginTransaction(); 
			
			// get the Chef object by Id from the DB
			chef = session.get(Chef.class, id);
			
			// commit the transaction 
			session.getTransaction().commit();
		} catch(Throwable e) { // will catch all errors and exceptions
			e.printStackTrace();
			
			// rollback to state before transaction started
			session.getTransaction().rollback();
		} finally {
			// always close the session
			session.close();
		}
		return chef;
	}
	
	

	@Override
	public Chef getChefByUsernameAndPassword(String username, String password) {
		// create a Chef object
		Chef chef = null;
		// retrieve the session from the Session Factory
		Session session = factory.getCurrentSession();
		try {
			// start the transaction
			session.beginTransaction(); 
			
			// Query for chef with the given username and password
			Query chefQuery = session.createQuery("From Chef c where c.username = ? OR c.password = ?");
			
			// set HQL Parameters (like PreparedStatement)
			chefQuery.setParameter(0, username);
			chefQuery.setParameter(1, password);
			
			// Get the results from the query 
			List<Chef> chefs = chefQuery.getResultList();
			chef = chefs.get(0);
			
			// commit the transaction 
			session.getTransaction().commit();
			
		} catch(Throwable e) { // will catch all errors and exceptions
			e.printStackTrace();
			
			// rollback to state before transaction started
			session.getTransaction().rollback();
		} finally {
			// always close the session
			session.close();
		}
		return chef;
	}*/
	
}
