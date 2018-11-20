package com.topshelf.beans;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

public class CookBook {
	
	private int chefId;
	
	
	private int recipeId;

	public CookBook() {
		super();
	}

	public CookBook(int chefId, int recipeId) {
		super();
		this.chefId = chefId;
		this.recipeId = recipeId;
	}

	public int getChefId() {
		return chefId;
	}

	public void setChefId(int chefId) {
		this.chefId = chefId;
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chefId;
		result = prime * result + recipeId;
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
		CookBook other = (CookBook) obj;
		if (chefId != other.chefId)
			return false;
		if (recipeId != other.recipeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CookBook [chefId=" + chefId + ", recipeId=" + recipeId + "]";
	}
	
	
        
}
