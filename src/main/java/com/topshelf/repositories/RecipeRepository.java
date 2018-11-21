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

import com.topshelf.beans.Recipe;
import com.topshelf.util.ObjectTypeConverter;

@Repository
public class RecipeRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public RecipeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void addNewRecipe(Recipe newRecipe) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		
		JSONObject json = new JSONObject();
		json = ObjectTypeConverter.convertListToJson(newRecipe.getIngredientList());
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		newRecipe.setIngredient(blob);
		session.save(newRecipe);
	}
}
