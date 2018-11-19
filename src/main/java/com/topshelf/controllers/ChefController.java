package com.topshelf.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topshelf.beans.Chef;
import com.topshelf.services.ChefService;

@CrossOrigin
@RestController
@RequestMapping(value="/chefs")
public class ChefController {
	private ChefService chefService;
	
	@Autowired
	public ChefController(ChefService chefService) {
		this.chefService = chefService;
	}
	
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> login(@RequestBody Chef chefCredentials) throws SQLException, JSONException {
		List<Object> loggedInChefInformation = chefService.loginChef(chefCredentials.getUsername(), chefCredentials.getPassword());
		if (loggedInChefInformation == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<List<Object>>(loggedInChefInformation, HttpStatus.OK);
	}
	
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addNewChef(@RequestBody Chef newChef) throws SerialException, UnsupportedEncodingException, SQLException {
		Chef registeredChef = chefService.addChef(newChef);
		
		if (registeredChef == null) {
			return new ResponseEntity<>(false, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
	
}
