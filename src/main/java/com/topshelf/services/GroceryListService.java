package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;
import com.topshelf.repositories.GroceryListRepository;

@Service
public class GroceryListService {
	private GroceryListRepository groceryListRepository;
	private GroceryList newList;
	
	@Autowired
	public GroceryListService(GroceryListRepository groceryListRepository, GroceryList newList) {
		this.groceryListRepository = groceryListRepository;
		this.newList = newList;
	}
	@Transactional
	public GroceryList newChefGroceryList() throws SerialException, UnsupportedEncodingException, SQLException {
		return groceryListRepository.addGroceryList(newList);
	}
	
	public GroceryList getGroceryList(int id) {
		return groceryListRepository.getGroceryListById(id);
	}
}
