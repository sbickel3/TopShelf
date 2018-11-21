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
@Table(name="Fridge")
@SequenceGenerator(name="fridge_seq", sequenceName="fridge_id_seq", allocationSize=1)
public class Fridge {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fridge_seq")
	private int id;
	
	@Column(name="ingredient")
	private Blob ingredientBlob;
	
	@Transient
	private ArrayList<Ingredient> ingredient;

	public Fridge() {
		super();
	}

	
	public Blob getIngredientBlob() {
		return ingredientBlob;
	}


	public void setIngredientBlob(Blob ingredientBlob) {
		this.ingredientBlob = ingredientBlob;
	}


	public Fridge(Blob ingredientBlob, ArrayList<Ingredient> ingredient) {
		super();
		this.ingredientBlob = ingredientBlob;
		this.ingredient = ingredient;
	}
	
	
	public Fridge(int id, ArrayList<Ingredient> ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}
	
	public Fridge(int id, Blob ingredient) {
		super();
		this.id = id;
		this.ingredientBlob = ingredient;
	}
	
	public Fridge(Blob ingredient) {
		super();
		this.ingredientBlob = ingredient;
	}

	public Fridge(int id) {
		super();
		this.id = id;
	}

	public Fridge(ArrayList<Ingredient> ingredient) {
		super();
		this.ingredient = ingredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Fridge other = (Fridge) obj;
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
		return "Fridge [id=" + id + ", ingredient=" + ingredient + "]";
	}
}

//	public Fridge(int id, Blob ingredient){
//		super();
//		this.id = id;
//		this.ingredient = ingredient;
//	}
//
//	public Fridge(Blob ingredient) {
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
//		return "Fridge [id=" + id + ", ingredient=" + ingredient + "]";
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
//		Fridge other = (Fridge) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}
//	
//}
