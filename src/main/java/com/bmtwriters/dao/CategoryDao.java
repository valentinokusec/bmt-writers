package com.bmtwriters.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.Category;
import com.bmtwriters.domains.User;

public interface CategoryDao extends JpaRepository<Category, Integer>{
	

	
}
