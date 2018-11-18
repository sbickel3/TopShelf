package com.topshelf.repositories;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Fridge;
import com.topshelf.util.ObjectTypeConverter;

@Repository
@Transactional
public class FridgeRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public FridgeRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Fridge addFridge(Fridge fridge) throws SerialException, UnsupportedEncodingException, SQLException {
		Session s = sessionFactory.getCurrentSession();
		JSONObject json = new JSONObject();
		fridge.setIngredient(ObjectTypeConverter.convertJSONtoBLOB(json));
		s.save(fridge);
		return fridge;
	}
	
	public Fridge getFridgeById(int id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Fridge.class, id);
	}
	
}
