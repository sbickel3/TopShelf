package com.topshelf.beans;

import java.sql.Blob;
import java.sql.Clob;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.topshelf.util.Ingredient;

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
	@NotNull
	private String name;
	
	@Column(name="instruction")
	private String instruction;               
	
	@Column(name="photo")
	private String photo;
	
//	@OneToOne(cascade=CascadeType.MERGE)
//	@PrimaryKeyJoinColumn(name="chef_id")
//	private Chef chef;
	
	@Column(name="chef_id")
	private int chefId;
	
	@Column(name="ingredient")
	private Blob ingredient;
	
	@Transient
	private ArrayList<Ingredient> ingredientList;
	
	//@ManyToMany(mappedBy = "authorRecipes")
	//private Set<Chef> recipeChefOwners;

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public Recipe() {
		super();
	}
	
	public Recipe(Blob ingredientBlob, ArrayList<Ingredient> ingredient) {
		super();
		this.ingredient = ingredientBlob;
		this.ingredientList = ingredient;
	}

	public Recipe(int id, @NotNull String name, String instruction, String photo, int chefId,
			ArrayList<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.name = name;
		this.instruction = instruction;
		this.photo = photo;
		this.chefId = chefId;
		this.ingredientList = ingredientList;
	}

	public Recipe(@NotNull String name, String instruction, String photo, int chefId,
			ArrayList<Ingredient> ingredientList) {
		super();
		this.name = name;
		this.instruction = instruction;
		this.photo = photo;
		this.chefId = chefId;
		this.ingredientList = ingredientList;
	}

	public Recipe(@NotNull String name, ArrayList<Ingredient> ingredientList) {
		super();
		this.name = name;
		this.ingredientList = ingredientList;
	}
	
	public Recipe(int id, @NotNull String name, ArrayList<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.name = name;
		this.ingredientList = ingredientList;
	}

	public Recipe(int id, @NotNull String name, int chefId, ArrayList<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.name = name;
		this.chefId = chefId;
		this.ingredientList = ingredientList;
	}

	public Recipe(@NotNull String name, int chefId, ArrayList<Ingredient> ingredientList) {
		super();
		this.name = name;
		this.chefId = chefId;
		this.ingredientList = ingredientList;
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

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getChefId() {
		return chefId;
	}

	public void setChefId(int chefId) {
		this.chefId = chefId;
	}

	public Blob getIngredient() {
		return ingredient;
	}

	public void setIngredient(Blob ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + chefId;
		result = prime * result + id;
		result = prime * result + ((ingredientList == null) ? 0 : ingredientList.hashCode());
		result = prime * result + ((instruction == null) ? 0 : instruction.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
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
		Recipe other = (Recipe) obj;
		if (chefId != other.chefId)
			return false;
		if (id != other.id)
			return false;
		if (ingredientList == null) {
			if (other.ingredientList != null)
				return false;
		} else if (!ingredientList.equals(other.ingredientList))
			return false;
		if (instruction == null) {
			if (other.instruction != null)
				return false;
		} else if (!instruction.equals(other.instruction))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", instruction=" + instruction + ", photo=" + photo + ", chefId="
				+ chefId + ", ingredient=" + ingredient + ", ingredientList=" + ingredientList + "]";
	}

	
	
}
