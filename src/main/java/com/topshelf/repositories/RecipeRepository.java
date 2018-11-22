package com.topshelf.repositories;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topshelf.beans.Recipe;
import com.topshelf.util.ObjectTypeConverter;

@Repository
public class RecipeRepository {
	private SessionFactory sessionFactory;
	

	@Autowired
	public RecipeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Recipe addNewRecipe(Recipe newRecipe) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		
		JSONObject json = new JSONObject();
		json = ObjectTypeConverter.convertListToJson(newRecipe.getIngredientList());
		Blob blob = ObjectTypeConverter.convertJSONtoBLOB(json);
		newRecipe.setIngredient(blob);
		session.save(newRecipe);
		return newRecipe;
	}
	
	public List<Recipe> getAllChefRecipes(int chefId){
		Session session = sessionFactory.getCurrentSession();
		Query allChefRecipes = session.createQuery("from Recipe r where r.chefId = ?");
		allChefRecipes.setParameter(0, chefId);
		List<Recipe> chefRecipes = allChefRecipes.getResultList();
		return chefRecipes;
	}
	
	public void updateRecipe(Recipe updatedRecipe) throws JSONException, SerialException, UnsupportedEncodingException, SQLException {
		Session session = sessionFactory.getCurrentSession();
		JSONObject json = ObjectTypeConverter.convertListToJson(updatedRecipe.getIngredientList());
		updatedRecipe.setIngredient(ObjectTypeConverter.convertJSONtoBLOB(json));
		session.merge(updatedRecipe);
	}
	
	public void deleteRecipe(Recipe deleteRecipe) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(deleteRecipe);
	}
}
