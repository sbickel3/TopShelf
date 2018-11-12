package com.topshelf.drivers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import com.topshelf.dao.ChefDAO;
import com.topshelf.dao.ChefDaoImpl;
import com.topshelf.models.Chef;
import com.topshelf.models.Fridge;
import com.topshelf.models.GroceryList;
import com.topshelf.util.ObjectTypeConverter;

public class ChefDriver {

	public static void main(String[] args) {
		
		// create a session factory 
//		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Chef.class)
//				.addAnnotatedClass(Fridge.class)
//				.addAnnotatedClass(GroceryList.class)
//				.buildSessionFactory();
		
		// retrieve the session from the Session Factory
//		Session session = factory.getCurrentSession();
		
		ChefDAO chefDao = new ChefDaoImpl();
		//Session session = chefDao.getSessionFactory().getCurrentSession();
		
		try {
			
			
			JSONObject obj = new JSONObject();
			obj.put("nuts",	45);
			obj.put("tomato", 35);
			
			
//			// create a Chef object, including objects its reference with (Fridge & GroceryList)
//			Fridge fridge = new Fridge(ingredient_blob);
//			GroceryList grocery = new GroceryList(ingredient_blob);
//			Chef chef = new Chef("Yuki", "Mano", "ym@gmail.com", "ysm", "password", fridge, grocery);
//			
//			System.out.println("Chef: " + chef);
//			
//			session.beginTransaction(); 
//			session.save(chef);
//			session.getTransaction().commit();
			
			//chefDao.insertNewChef("Caleb", "Massey", "cm@gmail.com", "cm", "password", ingredient_blob, ingredient_blob);
			
			//System.out.println("transaction complete");
			
			//Blob blob = rs.getBlob("SomeDatabaseField");
			
			
			//session.beginTransaction();
			//Chef chef = session.get(Chef.class, 7);
			
			
			Chef chef = chefDao.getChefById(7);
			System.out.println("Chef: " + chef);
			System.out.println("Fridge: " + ObjectTypeConverter.convertBLOBtoJSON(chef.getFridge().getIngredient()));
			
			System.out.println("transaction complete");
			
		
			
		} catch(Throwable e) { // will catch all errors and exceptions
			e.printStackTrace();
			
			// rollback to state before transaction started
			//session.getTransaction().rollback();
		} finally {
			// always close the session and session factory 
			//session.close();
			chefDao.getSessionFactory().close();
			
		}
		
	}
	
}
