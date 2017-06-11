package com.bmtwriters.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bmtwriters.domains.Book;
import com.bmtwriters.domains.Category;
import com.bmtwriters.domains.User;

public interface BookDao extends JpaRepository<Book, Integer>{
	Page<Book> findAllByCategory(Pageable pageable,Category Category);

	
}
