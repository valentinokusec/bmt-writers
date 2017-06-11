package com.bmtwriters.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bmtwriters.domains.Activity;
import com.bmtwriters.domains.Category;
import com.bmtwriters.domains.User;

public interface CategoryService {

	public void save(Category p);
	
	public List<Category> list();
	
}
