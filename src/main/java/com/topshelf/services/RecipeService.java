package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;
import com.topshelf.repositories.RecipeRepository;
import com.topshelf.util.ObjectTypeConverter;

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
	
	@Transactional
	public List<Recipe> getChefRecipes(int chefId) throws SQLException, JSONException{
		List<Recipe> recipeBlobIngredients = recipeRepository.getAllChefRecipes(chefId);
		List<Recipe> chefRecipes = extractListOfRecipes(recipeBlobIngredients);
		return chefRecipes;
	}
	
	@Transactional
	public void updateRecipe(Recipe updatedRecipe) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		recipeRepository.updateRecipe(updatedRecipe);
	}
	
	@Transactional
	public void deleteRecipe(int recipeId) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		boolean recipeExists = this.cookBookService.deleteRecipeFromCookBook(recipeId);
		if (recipeExists) {
			recipeRepository.deleteRecipe(recipeId);
		}
	}
	
	@Transactional
	public List<Recipe> getAllRecipes() throws SQLException, JSONException{
		List<Recipe> recipeBlobIngredients = this.recipeRepository.getAllRecipes();
		List<Recipe> allRecipes = extractListOfRecipes(recipeBlobIngredients);
		return allRecipes;
	}
	
	private List<Recipe> extractListOfRecipes(List<Recipe> listToConvert) throws SQLException, JSONException{
		List<Recipe> recipesToReturn = new ArrayList<Recipe>();
		for (Recipe recipe: listToConvert) {
			Recipe chefRecipe = new Recipe();
			chefRecipe.setId(recipe.getId());
			chefRecipe.setName(recipe.getName());
			chefRecipe.setInstruction(recipe.getInstruction());
			chefRecipe.setPhoto(recipe.getPhoto());
			chefRecipe.setChefId(recipe.getChefId());
			chefRecipe.setIngredientList(ObjectTypeConverter.convertBlobToList(recipe.getIngredient()));
			recipesToReturn.add(chefRecipe);
		}
		return recipesToReturn;
	}
}
