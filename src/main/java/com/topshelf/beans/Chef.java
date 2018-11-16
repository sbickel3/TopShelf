package com.topshelf.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Component
@Table(name="CHEF", uniqueConstraints=
@UniqueConstraint(columnNames={"email", "username"}))
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@SequenceGenerator(name="chef_seq", sequenceName="chef_id_seq", allocationSize=1)
public class Chef {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chef_seq")
	private int id;
	
	@Column(name="firstname")
	@NotNull
	private String firstname;
	
	@Column(name="lastname")
	@NotNull
	private String lastname;
	
	@Column(name="email")
	@NotNull
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;
	
	@Column(name="username")
	@NotNull
	@Size(min=4, max=16)
	private String username;
	
	
	@Column(name="password")
	@Size(min=4)
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fridge_id")
	private Fridge fridge;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="grocery_id")
	private GroceryList grocery;
	
	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="authorRecipes",
				joinColumns = @JoinColumn(name = "chef_id"),
				inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private Set<Recipe> authorRecipes;

	public Chef() {
		super();
	}

	public Chef(int id, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") String email,
			@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password, Fridge fridge,
			GroceryList grocery, Set<Recipe> authorRecipes) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.fridge = fridge;
		this.grocery = grocery;
		this.authorRecipes = authorRecipes;
	}

	public Chef(int id, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") String email,
			@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password, Fridge fridge,
			GroceryList grocery) {
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

	public Set<Recipe> getAuthorRecipes() {
		return authorRecipes;
	}

	public void setAuthorRecipes(Set<Recipe> authorRecipes) {
		this.authorRecipes = authorRecipes;
	}

	@Override
	public String toString() {
		return "Chef [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", fridge=" + fridge + ", grocery=" + grocery
				+ ", authorRecipes=" + authorRecipes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorRecipes == null) ? 0 : authorRecipes.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Chef other = (Chef) obj;
		if (authorRecipes == null) {
			if (other.authorRecipes != null)
				return false;
		} else if (!authorRecipes.equals(other.authorRecipes))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

}
