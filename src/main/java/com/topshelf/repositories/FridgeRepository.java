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

import com.topshelf.beans.Fridge;
import com.topshelf.util.ObjectTypeConverter;

@Repository
public class FridgeRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public FridgeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public Fridge addFridge(Fridge fridge) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		fridge.setIngredientBlob(blob);
		//json = ObjectTypeConverter.convertListToJson(ingredients)
		s.save(fridge);
		return fridge;
	}
	
	public Fridge getFridgeById(int id) throws SQLException, JSONException, UnsupportedEncodingException {
		Session s = sessionFactory.getCurrentSession();
		
		Fridge fridge = s.get(Fridge.class, id);
//		JSONObject json = new JSONObject();
//		fridge.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		fridge.setIngredient(ObjectTypeConverter.convertBlobToList(fridge.getIngredientBlob()));
		
		return fridge;
	}
	

	public void updateFridge(Fridge fridgeToModify) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = ObjectTypeConverter.convertListToJson(fridgeToModify.getIngredient());
		
		fridgeToModify.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		s.merge(fridgeToModify);
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

import com.topshelf.beans.Fridge;
import com.topshelf.util.ObjectTypeConverter;

@Repository
public class FridgeRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public FridgeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public Fridge addFridge(Fridge fridge) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		fridge.setIngredientBlob(blob);
		//json = ObjectTypeConverter.convertListToJson(ingredients)
		s.save(fridge);
		return fridge;
	}
	
	public Fridge getFridgeById(int id) throws SQLException, JSONException, UnsupportedEncodingException {
		Session s = sessionFactory.getCurrentSession();
		
		Fridge fridge = s.get(Fridge.class, id);
//		JSONObject json = new JSONObject();
//		fridge.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		fridge.setIngredient(ObjectTypeConverter.convertBlobToList(fridge.getIngredientBlob()));
		
		return fridge;
	}
	

	public void updateFridge(Fridge fridgeToModify) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = ObjectTypeConverter.convertListToJson(fridgeToModify.getIngredient());
		
		fridgeToModify.setIngredientBlob(ObjectTypeConverter.convertJSONtoBLOB(json));
		s.merge(fridgeToModify);
	}
	
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
}