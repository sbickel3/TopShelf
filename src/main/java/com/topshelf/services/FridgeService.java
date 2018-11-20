package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Fridge;
import com.topshelf.repositories.FridgeRepository;

@Service
public class FridgeService {
	private FridgeRepository fridgeRepository;
	private Fridge fridge;
	
	@Autowired
	public FridgeService(FridgeRepository fridgeRepository, Fridge fridge) {
		this.fridgeRepository = fridgeRepository;
		this.fridge = fridge;
	}
	
	@Transactional
	public Fridge newChefFridge() throws SerialException, UnsupportedEncodingException, SQLException {
		return fridgeRepository.addFridge(this.fridge);
	}
	
	public Fridge getFridge(int id) throws SQLException, JSONException, UnsupportedEncodingException {
		return fridgeRepository.getFridgeById(id);
	}
	
	@Transactional
	public void updateFridge(Fridge updatedFridge) throws SerialException, UnsupportedEncodingException, JSONException, SQLException {
		fridgeRepository.updateFridge(updatedFridge);
	}
}
