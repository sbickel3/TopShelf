package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;
import com.topshelf.repositories.RecipeRepository;
<<<<<<< HEAD
import com.topshelf.util.ObjectTypeConverter;
=======
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa

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
<<<<<<< HEAD
	
	@Transactional
	public List<Recipe> getChefRecipes(int chefId) throws SQLException, JSONException{
		List<Recipe> recipeBlobIngredients = recipeRepository.getAllChefRecipes(chefId);
		List<Recipe> chefRecipes = new ArrayList<Recipe>();
		for (Recipe recipe: recipeBlobIngredients) {
			Recipe chefRecipe = new Recipe();
			chefRecipe.setId(recipe.getId());
			chefRecipe.setName(recipe.getName());
			chefRecipe.setInstruction(recipe.getInstruction());
			chefRecipe.setPhoto(recipe.getPhoto());
			chefRecipe.setChefId(recipe.getChefId());
			chefRecipe.setIngredientList(ObjectTypeConverter.convertBlobToList(recipe.getIngredient()));
			chefRecipes.add(chefRecipe);
		}
		return chefRecipes;
	}
	
	@Transactional
	public void updateRecipe(Recipe updatedRecipe) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		recipeRepository.updateRecipe(updatedRecipe);
	}
	
	@Transactional
	public void deleteRecipe(Recipe deleteRecipe) {
		recipeRepository.deleteRecipe(deleteRecipe);
	}
=======
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
}
