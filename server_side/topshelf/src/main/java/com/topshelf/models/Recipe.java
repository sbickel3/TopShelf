package com.topshelf.models;

import java.sql.Blob;
import java.sql.Clob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECIPE")
@SequenceGenerator(name="recipe_seq", sequenceName="recipe_id_seq", allocationSize=1)
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
	private Blob photo;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	private Chef chef;
	
	@Column(name="ingredient")
	private Blob ingredient;
	
	public Recipe() {}

	public Recipe(int id, String name, Clob instruction, Blob photo, Chef chef, Blob ingredient) {
		super();
		this.id = id;
		this.name = name;
		this.instruction = instruction;
		this.photo = photo;
		this.chef = chef;
		this.ingredient = ingredient;
	}

	public Recipe(String name, Clob instruction, Blob photo, Chef chef, Blob ingredient) {
		super();
		this.name = name;
		this.instruction = instruction;
		this.photo = photo;
		this.chef = chef;
		this.ingredient = ingredient;
	}
	
	public Recipe(String name, Clob instruction, Chef chef, Blob ingredient) {
		super();
		this.name = name;
		this.instruction = instruction;
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

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
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

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", instruction=" + instruction + ", photo=" + photo + ", chef="
				+ chef + ", ingredient=" + ingredient + "]";
	}
}
