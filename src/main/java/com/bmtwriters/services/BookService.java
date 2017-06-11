package com.bmtwriters.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bmtwriters.domains.Activity;
import com.bmtwriters.domains.Book;
import com.bmtwriters.domains.Category;
import com.bmtwriters.domains.User;

public interface BookService {

	public void save(Book p);
	
	public List<Book> list();
	public Book findById(int id);

	Page<Book> findAllByCategory(Pageable pageable,Category Category);
	
}
