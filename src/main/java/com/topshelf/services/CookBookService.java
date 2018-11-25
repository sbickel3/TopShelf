package com.topshelf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topshelf.beans.CookBook;
import com.topshelf.repositories.CookBookRepository;

@Service
public class CookBookService {
	private CookBookRepository cookBookRepository;
	
	@Autowired
	public CookBookService(CookBookRepository cookBookRepository) {
		this.cookBookRepository = cookBookRepository;
	}
	
	@Transactional
	public void addCookBookEntry(CookBook entry) {
		this.cookBookRepository.addCookbookEntry(entry);
	}
}
