package com.topshelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Fridge;
import com.topshelf.repositories.FridgeRepository;

@Service
public class FridgeService {
	private FridgeRepository fridgeRepository;
	
	@Autowired
	public FridgeService(FridgeRepository fridgeRepository) {
		this.fridgeRepository = fridgeRepository;
	}
	
	@Transactional
	public Fridge newChefFridge() {
		Fridge fridge = new Fridge();
		return fridgeRepository.addFridge(fridge);
	}
}
