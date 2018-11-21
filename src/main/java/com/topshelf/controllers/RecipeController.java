package com.topshelf.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topshelf.beans.Recipe;
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
	
	@GetMapping(value="/{chefId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getChefRecipes(@PathVariable int chefId) throws SQLException, JSONException {
		List<Recipe> chefRecipes = recipeService.getChefRecipes(chefId);
		return new ResponseEntity<List<Recipe>>(chefRecipes, HttpStatus.OK);
	}

	@PostMapping(value="/new", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addNewRecipe(@RequestBody Recipe newRecipe) throws SQLException, JSONException, UnsupportedEncodingException {
		recipeService.addRecipe(newRecipe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
