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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.services.FridgeService;

@CrossOrigin
@RestController
@RequestMapping(value="/fridge")
public class FridgeController {
	
	private FridgeService fridgeService;
	
	@Autowired
	public FridgeController(FridgeService fridgeService) {
		this.fridgeService = fridgeService;
	}
	
	@PutMapping(value="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateFridge(@RequestBody Fridge updatedFridge) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		fridgeService.updateFridge(updatedFridge);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
