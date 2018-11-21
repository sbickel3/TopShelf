package com.topshelf.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;
import com.topshelf.services.CookBookService;
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
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Recipe>> getFlashCardById(@PathVariable int chefId) {
		
		
		return new ResponseEntity<ArrayList<Recipe>>(HttpStatus.OK);
		
	}

	@PostMapping(value="/new", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addNewRecipe(@RequestBody Recipe newRecipe) throws SQLException, JSONException, UnsupportedEncodingException {
		recipeService.addRecipe(newRecipe);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
