package com.topshelf.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.Chef;

@Repository
public class ChefRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public ChefRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Chef getChefById(int id) {
		Session s = sessionFactory.getCurrentSession();
		return s.get(Chef.class, id);
	}
	
	public Chef insertNewChef(Chef newChef) {
		Session s = sessionFactory.getCurrentSession();
		Query createNewChef = s.createQuery("from Chef c where c.username = ? or c.email = ?");
		createNewChef.setParameter(0, newChef.getUsername());
		createNewChef.setParameter(1, newChef.getEmail());
		List<Chef> newUserResult = createNewChef.getResultList();
		if (newUserResult.size() > 0) {
			return null;
		}
		s.save(newChef);
		return newChef;
	}
	
	public Chef getChefByUsername(String username) {
		Session s = sessionFactory.getCurrentSession();
		Query queryChef = s.createQuery("from Chef c where c.username = ?");
		queryChef.setParameter(0, username);
		List<Chef> desiredChef = queryChef.getResultList();
		return desiredChef.get(0);
	}
	
	
	public Chef login(String username, String password) {
		Session s = sessionFactory.getCurrentSession();
		Query queryChef = s.createQuery("from Chef c where c.username = ? and c.password = ?");
		queryChef.setParameter(0, username);
		queryChef.setParameter(1, password);
		List<Chef> queryResult = queryChef.getResultList();
		if (queryResult.size() == 0) {
			return null;
		}else {
			Chef loggedInChef = queryResult.get(0);
			return loggedInChef;
		}
	}
}
