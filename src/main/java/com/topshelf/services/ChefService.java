package com.topshelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
import com.topshelf.repositories.ChefRepository;

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


	public Chef loginChef(String username, String password) {
		return chefRepository.login(username, password);
		
	}
	@Transactional
	public Chef addChef(Chef newChef) {
		Fridge fridge = fridgeService.newChefFridge();
		GroceryList list = groceryListService.newChefGroceryList();
		newChef.setFridge(fridge.getId());
		newChef.setGrocery(list.getId());
		return chefRepository.insertNewChef(newChef);
	}
	
}
