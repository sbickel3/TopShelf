package com.topshelf.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topshelf.beans.GroceryList;
import com.topshelf.services.GroceryListService;

@CrossOrigin
@RestController
@RequestMapping(value="/grocerylist")
public class GroceryListController {

private GroceryListService groceryListService;
	
	@Autowired
	public GroceryListController(GroceryListService groceryListService) {
		this.groceryListService = groceryListService;
	}
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateGroceryList(@RequestBody GroceryList updatedGroceryList) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		groceryListService.updateGroceryList(updatedGroceryList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
