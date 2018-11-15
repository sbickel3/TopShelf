package com.topshelf.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="GROCERYLIST")
@SequenceGenerator(name="grocery_seq", sequenceName="grocery_id_seq", allocationSize=1)
public class GroceryList {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grocery_seq")
	private int id;
	
	@Column(name="ingredient")
	private Blob ingredient;
	
	public GroceryList() {}

	public GroceryList(int id, Blob ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}

	public GroceryList(Blob ingredient) {
		super();
		this.ingredient = ingredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getIngredient() {
		return ingredient;
	}

	public void setIngredient(Blob ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", ingredient=" + ingredient + "]";
	}
}
