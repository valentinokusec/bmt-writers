package com.bmtwriters.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bmtwriters.dao.ActivityDao;
import com.bmtwriters.dao.CategoryDao;
import com.bmtwriters.domains.Category;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

	@Autowired
    private CategoryDao categorydao;
	
	@Override
	public void save(Category p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@ModelAttribute("messages")
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categorydao.findAll();
	}

}
