package com.topshelf.beans;

import java.sql.Blob;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Component
@Table(name="Recipe")
@SequenceGenerator(name="recipe_seq", sequenceName="recipe_id_seq", allocationSize=1)
@JsonIgnoreProperties({"hibernateLazyInitializer"})                                                                                                                                                                         
public class Recipe {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="recipe_seq")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="instruction")
	private Clob instruction;
	
	@Column(name="photo")
	private Clob photo;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@PrimaryKeyJoinColumn(name="chef_id")
	private Chef chef;
	
	@Column(name="ingredient")
	private Blob ingredient;
	

	//@ManyToMany(mappedBy = "authorRecipes")
	//private Set<Chef> recipeChefOwners;

	public Recipe() {
		super();
	}

//	public Recipe(int id, String name, Clob instruction, Clob photo, Chef chef, Blob ingredient,
//			Set<Chef> recipeChefOwners) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.instruction = instruction;
//		this.photo = photo;
//		this.chef = chef;
//		this.ingredient = ingredient;
//		this.recipeChefOwners = recipeChefOwners;
//	}

	public Recipe(int id, String name, Clob instruction, Clob photo, Chef chef, Blob ingredient) {
		super();
		this.id = id;
		this.name = name;
		this.instruction = instruction;
		this.photo = photo;
		this.chef = chef;
		this.ingredient = ingredient;
	}
	
	

	public Recipe(int id, String name, Chef chef, Blob ingredient) {
		super();
		this.id = id;
		this.name = name;
		this.chef = chef;
		this.ingredient = ingredient;
	}
	
	

	public Recipe(String name, Chef chef, Blob ingredient) {
		super();
		this.name = name;
		this.chef = chef;
		this.ingredient = ingredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clob getInstruction() {
		return instruction;
	}

	public void setInstruction(Clob instruction) {
		this.instruction = instruction;
	}

	public Clob getPhoto() {
		return photo;
	}

	public void setPhoto(Clob photo) {
		this.photo = photo;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public Blob getIngredient() {
		return ingredient;
	}

	public void setIngredient(Blob ingredient) {
		this.ingredient = ingredient;
	}

//	public Set<Chef> getRecipeChefOwners() {
//		return recipeChefOwners;
//	}
//
//	public void setRecipeChefOwners(Set<Chef> recipeChefOwners) {
//		this.recipeChefOwners = recipeChefOwners;
//	}	
	
}
