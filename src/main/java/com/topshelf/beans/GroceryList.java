package com.topshelf.beans;

import java.sql.Blob;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.topshelf.util.Ingredient;

@Entity
@Component
@Table(name="Grocerylist")
@SequenceGenerator(name="grocery_seq", sequenceName="grocery_id_seq", allocationSize=1)
public class GroceryList {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grocery_seq")
	private int id;
	
	@Column(name="ingredient")
	private Blob ingredientBlob;
	
	@Transient
	private ArrayList<Ingredient> ingredient;
	
	

	public GroceryList(ArrayList<Ingredient> ingredient) {
		super();
		this.ingredient = ingredient;
	}

	public GroceryList(Blob ingredientBlob) {
		super();
		this.ingredientBlob = ingredientBlob;
	}

	public GroceryList(Blob ingredientBlob, ArrayList<Ingredient> ingredient) {
		super();
		this.ingredientBlob = ingredientBlob;
		this.ingredient = ingredient;
	}

	public GroceryList(int id, Blob ingredientBlob) {
		super();
		this.id = id;
		this.ingredientBlob = ingredientBlob;
	}

	public GroceryList(int id, ArrayList<Ingredient> ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}

	public GroceryList(int id, Blob ingredientBlob, ArrayList<Ingredient> ingredient) {
		super();
		this.id = id;
		this.ingredientBlob = ingredientBlob;
		this.ingredient = ingredient;
	}

	public GroceryList() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Blob getIngredientBlob() {
		return ingredientBlob;
	}

	public void setIngredientBlob(Blob ingredientBlob) {
		this.ingredientBlob = ingredientBlob;
	}

	public ArrayList<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(ArrayList<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		if (id != other.id)
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", ingredientBlob=" + ingredientBlob + ", ingredient=" + ingredient + "]";
	}


	
	

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grocery_seq")
//	private int id;
//	
//	@Column(name="ingredient")
//	private Blob ingredient;
//	
//	public GroceryList() {}
//
//	public GroceryList(int id, Blob ingredient) {
//		super();
//		this.id = id;
//		this.ingredient = ingredient;
//	}
//
//	public GroceryList(Blob ingredient) {
//		super();
//		this.ingredient = ingredient;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Blob getIngredient() {
//		return ingredient;
//	}
//
//	public void setIngredient(Blob ingredient) {
//		this.ingredient = ingredient;
//	}
//
//	@Override
//	public String toString() {
//		return "GroceryList [id=" + id + ", ingredient=" + ingredient + "]";
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		GroceryList other = (GroceryList) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

