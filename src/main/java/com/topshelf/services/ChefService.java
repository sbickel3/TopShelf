package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
import com.topshelf.repositories.ChefRepository;
import com.topshelf.util.Ingredient;
import com.topshelf.util.ObjectTypeConverter;
import com.topshelf.util.User;

@Service
public class ChefService {

	private ChefRepository chefRepository;
	private FridgeService fridgeService;
	private GroceryListService groceryListService;
	
	@Autowired
	public ChefService(ChefRepository chefRepository, FridgeService fridgeService, GroceryListService groceryListService) {
		this.chefRepository = chefRepository;
		this.fridgeService = fridgeService;
		this.groceryListService = groceryListService;
	}

	
	@Transactional
	public User loginChef(String username, String password) throws SQLException, JSONException, UnsupportedEncodingException {
		Chef loggedInChef = chefRepository.login(username, password);
		if (loggedInChef == null) {
			return null;
		}
		
		Fridge fridge = fridgeService.getFridge(loggedInChef.getFridgeId());
		GroceryList grocery = groceryListService.getGroceryList(loggedInChef.getGroceryId());
		
		Fridge chefFridge = new Fridge(); 
		chefFridge.setId(fridge.getId());
		chefFridge.setIngredient(ObjectTypeConverter.convertBlobToList(fridge.getIngredientBlob()));
		
		GroceryList chefGrocery = new GroceryList();
		chefGrocery.setId(grocery.getId());
		chefGrocery.setIngredient(ObjectTypeConverter.convertBlobToList(grocery.getIngredientBlob()));
		
		return new User(loggedInChef, chefFridge, chefGrocery);
	}
	
	@Transactional
	public Chef addChef(Chef newChef) throws SerialException, UnsupportedEncodingException, SQLException {
		Fridge fridge = fridgeService.newChefFridge();
		GroceryList list = groceryListService.newChefGroceryList();
		newChef.setFridgeId(fridge.getId());
		newChef.setGroceryId(list.getId());
		return chefRepository.insertNewChef(newChef);
	}
}
