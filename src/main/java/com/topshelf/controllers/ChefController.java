package com.topshelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topshelf.beans.Chef;
import com.topshelf.services.ChefService;

@RestController
@RequestMapping(value="/chefs")
public class ChefController {
	private ChefService chefService;
	
	@Autowired
	public ChefController(ChefService chefService) {
		this.chefService = chefService;
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Chef> login(@RequestBody String[] chefCredentials) {
		Chef loggedInChef = chefService.loginChef(chefCredentials[0], chefCredentials[1]);
		if (loggedInChef == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Chef>(loggedInChef, HttpStatus.OK);
	}
	
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addNewChef(@RequestBody Chef newChef) {
		Chef registeredChef = chefService.addChef(newChef);
		
		if (registeredChef == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
}
