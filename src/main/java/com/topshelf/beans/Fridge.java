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
@Table(name="FRIDGE")
@SequenceGenerator(name="fridge_seq", sequenceName="fridge_id_seq", allocationSize=1)
public class Fridge {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fridge_seq")
	private int id;
	
	@Column(name="ingredient")
	private Blob ingredient;

	public Fridge() {
		super();
	}

	public Fridge(int id, Blob ingredient) {
		super();
		this.id = id;
		this.ingredient = ingredient;
	}

	public Fridge(Blob ingredient) {
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
		return "Fridge [id=" + id + ", ingredient=" + ingredient + "]";
	}
}
