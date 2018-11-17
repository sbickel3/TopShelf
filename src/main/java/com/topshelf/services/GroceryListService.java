package com.topshelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.GroceryList;
import com.topshelf.repositories.GroceryListRepository;

@Service
public class GroceryListService {
	private GroceryListRepository groceryListRepository;
	
	@Autowired
	public GroceryListService(GroceryListRepository groceryListRepository) {
		this.groceryListRepository = groceryListRepository;
	}
	@Transactional
	public GroceryList newChefGroceryList() {
		GroceryList newList = new GroceryList();
		return groceryListRepository.addGroceryList(newList);
	}
}
