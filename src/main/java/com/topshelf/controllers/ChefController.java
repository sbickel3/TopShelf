package com.topshelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.topshelf.beans.Chef;
import com.topshelf.exceptions.ChefNotFoundException;
import com.topshelf.services.ChefService;

@RestController
@CrossOrigin
@RequestMapping(value="/login")
public class ChefController {
	private ChefService chefService;
	
	@Autowired
	public ChefController(ChefService chefService) {
		this.chefService = chefService;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> login(@RequestBody String[] chefCredentials) {
		Chef loggedInChef = this.chefService.loginChef(chefCredentials[0], chefCredentials[1]);
		if (loggedInChef == null) {
			throw new ChefNotFoundException("Flash card with id " + chefCredentials[0] + " not found");
		}
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}
