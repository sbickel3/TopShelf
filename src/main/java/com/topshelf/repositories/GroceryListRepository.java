package com.topshelf.repositories;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
import com.topshelf.util.ObjectTypeConverter;
@Repository
public class GroceryListRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public GroceryListRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public GroceryList addGroceryList(GroceryList groceryList) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		groceryList.setIngredient(ObjectTypeConverter.convertJSONtoBLOB(json));
		s.save(groceryList);
		return groceryList;
	}
	
	public GroceryList getGroceryListById(int id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(GroceryList.class, id);
	}
}