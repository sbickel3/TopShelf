package com.topshelf.beans;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Component
@Table(name="Chef", uniqueConstraints=
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
	
	@Column(name="fridge_id")
	private int fridgeId;
	
	@Column(name="grocery_id")
	private int groceryId;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="fridge_id")
//	private Fridge fridge;
//	
//	@OneToOne(cascade= CascadeType.ALL)
//	@JoinColumn(name="grocery_id")
//	private GroceryList grocery;
//	
//	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST})
//	@JoinTable(name="authorRecipes",
//				joinColumns = @JoinColumn(name = "chef_id"),
//				inverseJoinColumns = @JoinColumn(name = "recipe_id")
//	)
//	private Set<Recipe> authorRecipes;

	public Chef() {
		super();
	}

	public Chef(int id, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") String email,
			@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password, int fridgeId,
			int groceryId) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.fridgeId = fridgeId;
		this.groceryId = groceryId;
	}

	public Chef(int id, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") String email,
			@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Chef(@NotNull String firstname, @NotNull String lastname,
			@NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") String email,
			@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	

	public Chef(@NotNull @Size(min = 4, max = 16) String username, @Size(min = 4) String password) {
		super();
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

	public int getFridgeId() {
		return fridgeId;
	}

	public void setFridgeId(int fridgeId) {
		this.fridgeId = fridgeId;
	}

	public int getGroceryId() {
		return groceryId;
	}

	public void setGroceryId(int groceryId) {
		this.groceryId = groceryId;
	}

	@Override
	public String toString() {
		return "Chef [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", fridgeId=" + fridgeId + ", groceryId="
				+ groceryId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + fridgeId;
		result = prime * result + groceryId;
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
		if (fridgeId != other.fridgeId)
			return false;
		if (groceryId != other.groceryId)
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
