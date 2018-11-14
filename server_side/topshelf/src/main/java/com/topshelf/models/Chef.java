package com.topshelf.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CHEF")
@SequenceGenerator(name="chef_seq", sequenceName="chef_id_seq", allocationSize=1)
public class Chef {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chef_seq")
	private int id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fridge_id")
	private Fridge fridge;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="grocery_id")
	private GroceryList grocery;
	
	public Chef() {}

	public Chef(int id, String firstname, String lastname, String email, String username, String password,
			Fridge fridge, GroceryList grocery) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.fridge = fridge;
		this.grocery = grocery;
	}

	public Chef(String firstname, String lastname, String email, String username, String password, Fridge fridge,
			GroceryList grocery) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.fridge = fridge;
		this.grocery = grocery;
	}

	public Chef(String firstname, String lastname, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String toString() {
		return "Chef [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", fridge=" + fridge + ", grocery=" + grocery
				+ "]";
	}
}
