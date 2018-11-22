<<<<<<< HEAD
package com.topshelf.repositories;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
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
	
	public GroceryList addGroceryList(GroceryList groceryList) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		groceryList.setIngredientBlob(blob);
		s.save(groceryList);
		return groceryList;
	}
	
	public GroceryList getGroceryListById(int id) throws SQLException, JSONException {
		Session s = sessionFactory.getCurrentSession();
		
		GroceryList groceryList = s.get(GroceryList.class, id);
		groceryList.setIngredient(ObjectTypeConverter.convertBlobToList(groceryList.getIngredientBlob()));
		
		return groceryList;
	}
	
	
	public void updateGroceryList(GroceryList groceryListToModify) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		
		JSONObject json = ObjectTypeConverter.convertListToJson(groceryListToModify.getIngredient());
		
		groceryListToModify.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		
		s.merge(groceryListToModify);
	}
=======
package com.topshelf.repositories;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
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
	
	public GroceryList addGroceryList(GroceryList groceryList) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		groceryList.setIngredientBlob(blob);
		s.save(groceryList);
		return groceryList;
	}
	
	public GroceryList getGroceryListById(int id) throws SQLException, JSONException {
		Session s = sessionFactory.getCurrentSession();
		
		GroceryList groceryList = s.get(GroceryList.class, id);
		groceryList.setIngredient(ObjectTypeConverter.convertBlobToList(groceryList.getIngredientBlob()));
		
		return groceryList;
	}
	
	
	public void updateGroceryList(GroceryList groceryListToModify) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		
		JSONObject json = ObjectTypeConverter.convertListToJson(groceryListToModify.getIngredient());
		
		groceryListToModify.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		
		s.merge(groceryListToModify);
	}
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
}