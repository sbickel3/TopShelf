package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;
import com.topshelf.repositories.RecipeRepository;

@Service
public class RecipeService {
	private RecipeRepository recipeRepository;
	private CookBookService cookBookService;
	
	
	@Autowired
	public RecipeService(RecipeRepository recipeRepository, CookBookService cookBookService) {
		this.recipeRepository = recipeRepository;
		this.cookBookService = cookBookService;
	}
	
	@Transactional
	public void addRecipe(Recipe newRecipe) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		Recipe newDbRecipe = this.recipeRepository.addNewRecipe(newRecipe);
		CookBook cookBookEntry = new CookBook(newDbRecipe.getChefId(), newDbRecipe.getId());
		this.cookBookService.addCookBookEntry(cookBookEntry);
	}
}
