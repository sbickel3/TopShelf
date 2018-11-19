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
	public List<Object> loginChef(String username, String password) throws SQLException, JSONException {
		Chef loggedInChef = chefRepository.login(username, password);
		if (loggedInChef == null) {
			return null;
		}
		List<Ingredient> loggedInChefFridgeIngredients = ObjectTypeConverter.convertBlobToList(fridgeService.getFridge(loggedInChef.getFridgeId()).getIngredient());
		List<Ingredient> loggedInChefGroceryListIngredients = ObjectTypeConverter.convertBlobToList(groceryListService.getGroceryList(loggedInChef.getGroceryId()).getIngredient());
		List<Object> list = new ArrayList<Object>();
		list.add(loggedInChef);
		list.add(loggedInChefFridgeIngredients);
		list.add(loggedInChefGroceryListIngredients);
		return list;
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
