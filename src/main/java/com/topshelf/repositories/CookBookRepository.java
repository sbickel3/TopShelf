package com.topshelf.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topshelf.beans.CookBook;
import com.topshelf.beans.Recipe;

@Repository
public class CookBookRepository {
	private SessionFactory sessionFactory;

	@Autowired
	public CookBookRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void addCookbookEntry(CookBook cookbook) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cookbook);
	}
	
	public boolean deleteCookBookRecipe(int recipeId) {
		Session session = sessionFactory.getCurrentSession();
		boolean recipeExists = determineIfRecipeExists(recipeId);
		if (!recipeExists) {
			return false;
		}
		Query deleteRecipes = session.createQuery("delete from CookBook cb where cb.recipeId = ?");
		deleteRecipes.setParameter(0, recipeId);
		deleteRecipes.executeUpdate();
		return true;
	}
	
	private boolean determineIfRecipeExists(int recipeId) {
		Session session = sessionFactory.getCurrentSession();
		Query getRecipe = session.createQuery("from CookBook cb where recipeId = ?");
		getRecipe.setParameter(0, recipeId);
		List<Recipe> recipeToDelete = getRecipe.getResultList();
		if (recipeToDelete.size() == 0) {
			return false;
		}
		return true;
	}
}
