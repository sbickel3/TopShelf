package com.topshelf.util;

import com.topshelf.beans.Chef;
import com.topshelf.beans.Fridge;
import com.topshelf.beans.GroceryList;

public class User {

	private Chef chef;
	private Fridge fridge;
	private GroceryList grocery; 
	
	public User() {
		super();
	}

	public User(Chef chef, Fridge fridge, GroceryList grocery) {
		super();
		this.chef = chef;
		this.fridge = fridge;
		this.grocery = grocery;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Fridge getFridge() {
		return fridge;
	}

	public void setFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public GroceryList getGrocery() {
		return grocery;
	}

	public void setGrocery(GroceryList grocery) {
		this.grocery = grocery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chef == null) ? 0 : chef.hashCode());
		result = prime * result + ((fridge == null) ? 0 : fridge.hashCode());
		result = prime * result + ((grocery == null) ? 0 : grocery.hashCode());
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
		User other = (User) obj;
		if (chef == null) {
			if (other.chef != null)
				return false;
		} else if (!chef.equals(other.chef))
			return false;
		if (fridge == null) {
			if (other.fridge != null)
				return false;
		} else if (!fridge.equals(other.fridge))
			return false;
		if (grocery == null) {
			if (other.grocery != null)
				return false;
		} else if (!grocery.equals(other.grocery))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [chef=" + chef + ", fridge=" + fridge + ", grocery=" + grocery + "]";
	}
}
