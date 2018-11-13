package com.topshelf.dao;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.topshelf.models.Chef;
import com.topshelf.models.Fridge;
import com.topshelf.models.GroceryList;

public class ChefDaoImpl implements ChefDAO{

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
	}
	
}
