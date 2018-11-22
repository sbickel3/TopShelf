package com.topshelf.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.ArrayList;
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.topshelf.beans.Recipe;
=======
import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;
import com.topshelf.services.CookBookService;
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
import com.topshelf.services.RecipeService;

@CrossOrigin
@RestController
@RequestMapping(value="/recipe")
public class RecipeController {
	private RecipeService recipeService;
	
	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
<<<<<<< HEAD
	@GetMapping(value="/{chefId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getChefRecipes(@PathVariable int chefId) throws SQLException, JSONException {
		List<Recipe> chefRecipes = recipeService.getChefRecipes(chefId);
		return new ResponseEntity<List<Recipe>>(chefRecipes, HttpStatus.OK);
=======
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Recipe>> getFlashCardById(@PathVariable int chefId) {
		
		
		return new ResponseEntity<ArrayList<Recipe>>(HttpStatus.OK);
		
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
	}

	@PostMapping(value="/new", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addNewRecipe(@RequestBody Recipe newRecipe) throws SQLException, JSONException, UnsupportedEncodingException {
		recipeService.addRecipe(newRecipe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
<<<<<<< HEAD
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateRecipe(@RequestBody Recipe updatedRecipe) throws SQLException, JSONException, UnsupportedEncodingException {
		recipeService.updateRecipe(updatedRecipe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> deleteRecipe(@RequestBody Recipe recipeToDelete){
		recipeService.deleteRecipe(recipeToDelete);
		return new ResponseEntity<>(HttpStatus.OK);
	}
=======
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
}
