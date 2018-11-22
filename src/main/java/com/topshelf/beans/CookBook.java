<<<<<<< HEAD
package com.topshelf.beans;

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
@Table(name="Cookbook")
@SequenceGenerator(name="cookbook_seq", sequenceName="cookbook_id_seq", allocationSize=1)
public class CookBook {
	
	@Id
	@Column(name="cookbook_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cookbook_seq")
	private int cookBookId;
	
	@Column(name="chef_id")
	private int chefId;
	
	
	@Column(name="recipe_id")
	private int recipeId;

	public CookBook() {
		super();
	}

	public CookBook(int chefId, int recipeId) {
		super();
		this.chefId = chefId;
		this.recipeId = recipeId;
	}

	public int getCookBookId() {
		return cookBookId;
	}

	public void setCookBookId(int cookBookId) {
		this.cookBookId = cookBookId;
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
		result = prime * result + cookBookId;
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
		if (cookBookId != other.cookBookId)
			return false;
		if (recipeId != other.recipeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CookBook [cookBookId=" + cookBookId + ", chefId=" + chefId + ", recipeId=" + recipeId + "]";
	}        
}
=======
package com.topshelf.beans;

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
@Table(name="Cookbook")
@SequenceGenerator(name="cookbook_seq", sequenceName="cookbook_id_seq", allocationSize=1)
public class CookBook {
	
	@Id
	@Column(name="cookbook_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cookbook_seq")
	private int cookBookId;
	
	@Column(name="chef_id")
	private int chefId;
	
	
	@Column(name="recipe_id")
	private int recipeId;

	public CookBook() {
		super();
	}

	public CookBook(int chefId, int recipeId) {
		super();
		this.chefId = chefId;
		this.recipeId = recipeId;
	}

	public int getCookBookId() {
		return cookBookId;
	}

	public void setCookBookId(int cookBookId) {
		this.cookBookId = cookBookId;
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
		result = prime * result + cookBookId;
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
		if (cookBookId != other.cookBookId)
			return false;
		if (recipeId != other.recipeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CookBook [cookBookId=" + cookBookId + ", chefId=" + chefId + ", recipeId=" + recipeId + "]";
	}        
}
>>>>>>> f60ca9336c9e8af8546554531dc4da3d4c235eaa
