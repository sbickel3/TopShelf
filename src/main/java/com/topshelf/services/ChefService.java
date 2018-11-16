package com.topshelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Chef;
import com.topshelf.repositories.ChefRepository;

@Service
@Transactional
public class ChefService {

	private ChefRepository chefRepository;
	
	@Autowired
	public ChefService(ChefRepository chefRepository) {
		this.chefRepository = chefRepository;
	}
	
	public Chef loginChef(String username, String password) {
		return chefRepository.login(username, password);
		
	}
	
}
