package com.topshelf.dao;

import java.sql.Blob;

import org.hibernate.SessionFactory;

import com.topshelf.models.Chef;

public interface ChefDAO {

	public SessionFactory getSessionFactory();
	
	public Chef getChefById(int id);
	public void insertNewChef(String firstname, String lastname, String email, String username, String password, Blob fridge, Blob grocery);
	
}
