package com.topshelf.services;

import com.topshelf.dao.ChefDAO;
import com.topshelf.dao.ChefDaoImpl;
import com.topshelf.models.Chef;

public class ChefService {

	private ChefDAO chefs = new ChefDaoImpl();
	
	public Chef loginChef(String username, String password) {
		return chefs.getChefByUsernameAndPassword(username, password);
		
	}
	
}
