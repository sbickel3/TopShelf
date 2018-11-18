package com.topshelf.services;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

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
	
	public Fridge getFridge(int id) {
		return fridgeRepository.getFridgeById(id);
	}
}
