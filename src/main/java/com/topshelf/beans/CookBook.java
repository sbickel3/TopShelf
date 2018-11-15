package com.topshelf.beans;

import javax.persistence.Column;

import org.springframework.stereotype.Component;
// https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
@Component
public class CookBook {
	@Column(name="chef_id")
	private int chefId;
	
	@Column(name="recipe_id")
	private int recipeId;
        
}
