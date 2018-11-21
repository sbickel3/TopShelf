package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topshelf.beans.Recipe;
import com.topshelf.controllers.RecipeController;
import com.topshelf.repositories.RecipeRepository;

@Service
public class RecipeService {
	private RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	public void addRecipe(Recipe newRecipe) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		this.recipeRepository.addNewRecipe(newRecipe);
	}
}
