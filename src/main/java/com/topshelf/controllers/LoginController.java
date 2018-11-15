package com.topshelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topshelf.beans.Chef;
import com.topshelf.exceptions.ChefNotFoundException;
import com.topshelf.services.ChefService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	private ChefService chefService;
	
	@Autowired
	public LoginController(ChefService chefService) {
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
